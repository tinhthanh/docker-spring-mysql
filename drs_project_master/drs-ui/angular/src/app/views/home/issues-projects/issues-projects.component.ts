import { Observable } from 'rxjs/observable';
import { ListenChangeRedmineService } from './../../../_services/manager/user/listen-change-redmine.service';
import { async } from '@angular/core/testing';
import { cacheStorage } from './../../../_cache/cacheStorage';
import { config } from './../../../_models/config';
import { CustomTaskComponent } from './components/custom-task/custom-task.component';
import { ShareFiltersService } from './../../../_services/manager/shared/share-filters.service';
import { SearchEngine } from './../../../_models/search-engine/SearchEngine';
import { UserService } from './../../../_services/manager/user/user.service';
import { Task } from './../../../_models/Task';
import { AdapterTask } from './../../../_models/AdapterTask';
import { PagerServiceService } from './../../../_services/manager/pagerservice/pager-service.service';
import { IssuesService } from './../../../_services/manager/issues/issues.service';
import { ManagerSearch } from './../../../_models/search-engine/ManagerSreach';
import { fakeProjects } from './../../../_helpers/mocktest/fake-data/fake-projects';
import { Component, OnInit, HostListener, ViewChild } from '@angular/core';
import { SelectItem } from 'ng2-select';
// import { ShareIssuesService } from '../../../_services/manager/shared/share-issues.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { filter } from 'rxjs/operators/filter';
import { Filters } from '../../../_models/search-engine/Filters';
import { CustomTask } from './models/CustomTask';
import { $ } from 'protractor';
import { ListenDataService } from '../../../_services/socket/listen-data.service';
import { UserInfo } from '../../../_models/user/user-info';
// import { CustomTask } from './models/CustomTask';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import { UserTokenState } from '../../../_models/user/user-token-state';
import { ISubscription } from 'rxjs/Subscription';
import { OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import 'rxjs/add/operator/filter';


@Component({
  selector: 'app-issues-projects',
  templateUrl: './issues-projects.component.html',
  styleUrls: ['./issues-projects.component.css']
})
export class IssuesProjectsComponent implements OnInit, OnDestroy {

  private subscription: ISubscription;
  max = 100;
  rateHover = 0;
  isReadonly = false;
  bsValue = new Date();
  indexEditRemark = -1;
  // pages
  pager: any = {};
  public pagedItems: any[] = [];
  itemSelectToDay: AdapterTask[] = [];
  itemSelectTomorrow: AdapterTask[] = [];

  isShowDescription = false;
  public itemsSelect: SelectItem[] = [];
  public items = new ManagerSearch().items;
  value: any = ['Athens'];
  _disabledV = '0';
  disabled = false;
  isShowNewTask = false;
  isShowCustomTask = true;
  isShowListSelect = false;
  isShowSendReport = false;
  isNotifyNotData = false; // notify not data view component
  isShowFilter = true;
  searchName = 'HUynh tinh thanh';
  filter = ''; // url filter
  managerFilters: Filters;
  searchList: SearchEngine[] = [];
  user: any = {};
  assigned: string;
  isLoading = false; // loading button page
  task: any; // task eidt
  private stompClient = null;
  socket = null;
  whoami = null;
  filterMultipleProject = '';
  @ViewChild(CustomTaskComponent) child: CustomTaskComponent;
  @HostListener('window:resize', ['$event'])
  onResize(event) {
    if (event.target.innerWidth > 999) {
      this.isShowListSelect = false;
    }
  }
  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
  constructor(private issuesService: IssuesService,
    private pagerServiceService: PagerServiceService,
    // private shareIssuesService: ShareIssuesService,
    private router: Router,
    private userService: UserService,
    private shareFiltersService: ShareFiltersService,
    private listenDataService: ListenDataService,
    private listenChangeRedmineService: ListenChangeRedmineService,
    private route: ActivatedRoute) {
    if (!localStorage.getItem(config.client.userToken)) { this.router.navigate(['/dashboard/login']); }
    this.listenChange();
    this.connect();
    //   this.listenDataService.getAllMessenger().subscribe(  async (res: any) => {
    //     if (sessionStorage.getItem(cacheStorage.userService.userInfo) ) {
    //       const userInfo: UserInfo = JSON.parse(decodeURIComponent(atob(sessionStorage.getItem(cacheStorage.userService.userInfo))));
    //     if ( res.recipient === userInfo.userName && !this.isShowSendReport ) {
    //       this.listenChange();
    //   }}}
    // );

    this.searchList = this.shareFiltersService.searchList;

    // this.itemSelectToDay = this.shareIssuesService.itemSelectToDay;
    // this.itemSelectTomorrow = this.shareIssuesService.itemSelectTomorrow;
    if (!localStorage.getItem(cacheStorage.listTask.today)) {
      // save
      localStorage.setItem(cacheStorage.listTask.today, btoa(encodeURIComponent(JSON.stringify(this.itemSelectToDay))));
    } else {
      const today: AdapterTask[] = JSON.parse(decodeURIComponent(atob(localStorage.getItem(cacheStorage.listTask.today))));
      today.forEach((res: AdapterTask, index) => {
        today[index].task.targetDate = new Date(res.task.targetDate);
      });
      this.itemSelectToDay = today;
    }
    if (!localStorage.getItem(cacheStorage.listTask.tomorrow)) {
      //  save
      localStorage.setItem(cacheStorage.listTask.tomorrow, btoa(encodeURIComponent(JSON.stringify(this.itemSelectTomorrow))));
    } else {
      const tomorrow: AdapterTask[] = JSON.parse(decodeURIComponent(atob(localStorage.getItem(cacheStorage.listTask.tomorrow))));
      tomorrow.forEach((res: AdapterTask, index) => {
        tomorrow[index].task.targetDate = new Date(res.task.targetDate);
      });
      this.itemSelectTomorrow = tomorrow;
    }

    this.userService.getUserInfo().subscribe((data: any) => {
      this.userService.getAllUser().subscribe((res: any[]) => {
        res.forEach(item => {
          if (item.mail === data.email) {
            this.user = item;
            this.assigned = `&assigned_to_id=${item.id}`;
            this.setPage(1);
          }
        });
      });
    }, (err: HttpErrorResponse) => {
      if (err.status === 401) {
        this.router.navigate(['/dashboard/login']);
      } else {
        console.log(err);
      }
    });
  }


  ngOnInit() {
    this.route.queryParams
      .filter(params => params.pId)
      .subscribe(params => {
        let temp = '&f[]=project_id&op[project_id]==';
        console.log(params.pId.length);
        if (params.pId.length === 1) {
          temp += `&v[project_id][]=${params.pId}`;
        } else {
          params.pId.forEach(p => {
            temp += `&v[project_id][]=${p}`;
          });
        }
        this.filterMultipleProject = temp;
        this.setPage(1);
        this.isShowFilter = false;
      });
  }
  twoWayBidingInput($event) {
    console.log($event);
  }
  callBackSearch($event) {
    console.log($event);
  }
  viewProjectsSelect() {
    this.isShowListSelect = false;
  }
  viewProjects() {
    this.isShowListSelect = true;
  }
  public changeIndexEditRemark(id: number) {
    this.indexEditRemark = id;
  }
  public viewReport() {
    this.saveListTask();
    this.router.navigate(['/dashboard/report']);
  }
  public sendReport() {
    this.saveListTask();
    this.isShowSendReport = true;
  }
  public getClassBadge(name: string): string {
    let result = 'label label-default';
    switch (name) {
      case 'Low':
        result = 'label label-default';
        break;
      case 'Normal':
        result = 'label label-default';
        break;
      case 'High':
        result = 'label label-warning';
        break;
      case 'Urgent':
        result = 'label label-danger';
        break;
      case 'Immediate':
        result = 'label label-danger';
        break;
      default:
        break;
    }
    return result;
  }
  public selected(value: any): void {
    this.itemsSelect.push(value);
  }

  public removed(value: any): void {
    const index = this.itemsSelect.indexOf(value, 0);
    if (index > -1) {
      this.searchList.forEach((item, i) => {
        if (item.root.id === value.id) {
          this.searchList.splice(i, 1);
          this.callBackListSearch(this.searchList);
        }
      });
      this.itemsSelect.splice(index, 1);
    }
  }

  public refreshValue(value: any): void {
    this.value = value;
  }

  public itemsToString(value: Array<any> = []): string {
    // console.log(value);
    return value
      .map((item: any) => {
        return item.text;
      }).join(',');
  }
  callBackListSearch($event) {
    console.log($event);
    this.managerFilters = new Filters($event);
    this.filter = this.managerFilters.getFilters();
    console.log(this.filter);
    this.setPage(1);
  }
  public callBackSend($event) {
    this.isShowSendReport = false;
  }
  cleanTaskList() {
    while (this.itemSelectToDay.length !== 0) {
      this.itemSelectToDay.forEach((item) => {
        this.removeSelectToday(item);
      });
    }
    while (this.itemSelectTomorrow.length !== 0) {
      this.itemSelectTomorrow.forEach((item) => {
        this.removeSelectToMorrow(item);
      });
    }
    this.saveListTask();
  }
  public searchByUser(item: SelectItem) {
    this.assigned = `&assigned_to_id=${item.id}`;
    this.setPage(1);
  }
  // pagesding
  public setPage(page: number) {
    this.isLoading = true;
    const size = 5;
    if (page < 1 || page > this.pager.totalPages) {
      this.isLoading = false;
      return;
    }
    // get pager object from service
    const offset = (page - 1) * size;
    const limit = size;
    this.issuesService.filter(`offset=${offset}&limit=${limit}${this.filter}${this.assigned}${this.filterMultipleProject}`).
      subscribe((data: any) => {
        if (data.listOfIssues && data.listOfIssues.length !== 0) {
          this.isNotifyNotData = true;
          this.pagedItems = data.listOfIssues;
          this.pager = this.pagerServiceService.getPager(data.totalCount, page, size);
        } else {
          this.isNotifyNotData = false;
        }
        this.isLoading = false;
      }, (err: HttpErrorResponse) => {
        this.isNotifyNotData = false;
        this.isLoading = false;
        this.router.navigate(['/dashboard/login']);
      });
  }
  public addItemToday($event): void {
    this.pagedItems.forEach((item, index) => {
      if (item.id === $event.id) {
        this.pagedItems[index].isToday = 2;
      }
    });
    const task = new Task();
    task.description = $event.description;
    task.remark = '';
    task.status = 100;
    task.targetDate = new Date();
    task.taskName = $event.subject;
    task.type = 1;
    const temp = { data: $event, task: task };
    this.itemSelectToDay.push(temp);
    this.saveListTask();
  }
  public addItemToMorrow($event): void {
    this.pagedItems.forEach((item, index) => {
      if (item.id === $event.id) {
        this.pagedItems[index].isTomorrow = 3;
      }
    });
    const task = new Task();
    task.description = $event.description;
    task.remark = '';
    task.status = 0;
    task.targetDate = new Date();
    task.taskName = $event.subject;
    task.type = 1;
    const temp = { data: $event, task: task };
    this.itemSelectTomorrow.push(temp);
    this.saveListTask();
  }
  public removeSelectToday($event) {
    if ($event.task.type === 1) {
      this.itemSelectToDay.forEach((item, index) => {
        if (item.data.id === $event.data.id) {
          // this.pagedItems.unshift($event.data);
          this.pagedItems.forEach((temp, count) => {
            if (temp.id === item.data.id) {
              this.pagedItems[count].isToday = 0;
            }
          });
          this.itemSelectToDay.splice(index, 1);
        }
      });
    }
    if ($event.task.type === 2) {
      this.itemSelectToDay.forEach((item, index) => {
        if (item.data.id === $event.data.id && item.task.type === 2) {
          this.itemSelectToDay.splice(index, 1);
        }
      });
    }
    if ($event.task.type === 3) {
      console.log($event.task.taskID);
      console.log($event.task);
      this.itemSelectToDay.forEach((item, index) => {
        if (item.data.id === $event.data.id && item.task.type === 3) {
          if (!sessionStorage.getItem(cacheStorage.listTask.rememberRemove)) {
            sessionStorage.setItem(cacheStorage.listTask.rememberRemove, JSON.stringify([]));
          }
          const rememberCache: number[] = JSON.parse(sessionStorage.getItem(cacheStorage.listTask.rememberRemove));
          rememberCache.push($event.task.taskID);
          sessionStorage.setItem(cacheStorage.listTask.rememberRemove, JSON.stringify(rememberCache));
          this.itemSelectToDay.splice(index, 1);
        }
      });
    }
    this.saveListTask();
  }
  public removeSelectToMorrow($event) {
    if ($event.task.type === 1) {
      this.itemSelectTomorrow.forEach((item, index) => {
        if (item.data.id === $event.data.id) {
          // this.pagedItems.unshift($event.data);
          this.pagedItems.forEach((temp, count) => {
            if (temp.id === item.data.id) {
              this.pagedItems[count].isTomorrow = 0;
            }
          });
          this.itemSelectTomorrow.splice(index, 1);
        }
      });
    }
    if ($event.task.type === 2) {
      this.itemSelectTomorrow.forEach((item, index) => {
        if (item.data.id === $event.data.id && item.task.type === 2) {
          this.itemSelectTomorrow.splice(index, 1);
        }
      });
    }
    if ($event.task.type === 3) {
      console.log($event.task.taskID);
      console.log($event.task);
      this.itemSelectTomorrow.forEach((item, index) => {
        if (item.data.id === $event.data.id && item.task.type === 3) {
          if (!sessionStorage.getItem(cacheStorage.listTask.rememberRemove)) {
            sessionStorage.setItem(cacheStorage.listTask.rememberRemove, JSON.stringify([]));
          }
          const rememberCache: number[] = JSON.parse(sessionStorage.getItem(cacheStorage.listTask.rememberRemove));
          rememberCache.push($event.task.taskID);
          sessionStorage.setItem(cacheStorage.listTask.rememberRemove, JSON.stringify(rememberCache));
          this.itemSelectTomorrow.splice(index, 1);
        }
      });
    }
    this.saveListTask();
  }
  moveToDay($event) {
    this.itemSelectTomorrow.forEach((item, index) => {
      if (item.data.id === $event.data.id) {
        this.itemSelectToDay.unshift($event);
        this.itemSelectTomorrow.splice(index, 1);
      }
    });
    this.saveListTask();
  }
  public addTomorrow(event) {
    console.log(event);
    if (event.task.status !== 100) {
      this.itemSelectToDay.forEach((item, index) => {
        if (item.data.id === event.data.id) {
          console.log(item);
          const today = new AdapterTask();
          today.data = { id: Math.floor((Math.random() * 100000) + 10000) };
          const task = new Task();
          task.taskID = event.task.taskID;
          task.description = event.task.description;
          task.remark = event.task.remark;
          task.status = event.task.status;
          task.targetDate = event.task.targetDate;
          task.taskName = event.task.taskName;
          task.type = event.task.type;
          today.task = task;
          this.itemSelectTomorrow.unshift(today);
        }
      });
    }
    this.saveListTask();
  }
  public toStringDate(date): string {
    const ng: number = date;
    const temp = new Date(ng);
    return `${temp.getMonth() + 1}/${temp.getDate()}/${temp.getFullYear()}`;
  }
  public customCardSelect($event) {

    if ($event.status === 1) {
      const today = new AdapterTask();
      today.data = { id: Math.floor((Math.random() * 1000000) + 100000) };
      const task = new Task();
      task.description = $event.data.description;
      task.remark = $event.data.remark;
      task.status = $event.data.task_status;
      task.targetDate = new Date($event.data.target_date);
      task.taskName = $event.data.task_name;
      task.type = 2;
      today.task = task;
      this.itemSelectToDay.push(today);
      console.log($event);
    } else if ($event.status === 2) {
      const tomorrow = new AdapterTask();
      tomorrow.data = { id: Math.floor((Math.random() * 1000000) + 100000) };
      const task = new Task();
      task.description = $event.data.description;
      task.remark = $event.data.remark;
      task.status = $event.data.task_status;
      task.targetDate = new Date($event.data.target_date);
      task.taskName = $event.data.task_name;
      task.type = 2;
      tomorrow.task = task;
      this.itemSelectTomorrow.push(tomorrow);
    }
    this.saveListTask();
  }
  public addNewTask($event) {
    const today = new AdapterTask();
    today.data = { id: Math.floor((Math.random() * 1000000) + 100000) };
    const task = new Task();
    task.description = $event.description;
    task.remark = $event.remark;
    task.status = $event.status;
    task.targetDate = $event.targetDate;
    task.taskName = $event.taskName;
    task.type = 2;
    today.task = task;
    this.itemSelectToDay.push(today);
    this.isShowNewTask = false;
    this.saveListTask();
  }
  public editCustomTask($event) {
    this.isShowNewTask = false;
    console.log($event);
    this.task = null;
    this.task = $event;
    setTimeout(() => { this.isShowNewTask = true; }, 100);
  }
  public resultEditCustomTask($event) {
    console.log($event);
    this.task = $event;
    // this.child.setTask(this.task);
    this.child.setItemEdit(this.task);
    this.isShowNewTask = false;
  }
  public saveListTask() {
    localStorage.setItem(cacheStorage.listTask.today, btoa(encodeURIComponent(JSON.stringify(this.itemSelectToDay))));
    localStorage.setItem(cacheStorage.listTask.tomorrow, btoa(encodeURIComponent(JSON.stringify(this.itemSelectTomorrow))));
  }
  public listenChange() {
    const resChange = [];
    if (localStorage.getItem(config.client.userToken)) {
      this.listenChangeRedmineService.updateChange().subscribe((r: any) => {
        if (!sessionStorage.getItem(cacheStorage.listTask.rememberRemove)) {
          sessionStorage.setItem(cacheStorage.listTask.rememberRemove, JSON.stringify([]));
        }
        const rememberCache: number[] = JSON.parse(sessionStorage.getItem(cacheStorage.listTask.rememberRemove));
        console.log(r.length + ' size change');
        r.forEach(it => {
          const list = rememberCache.filter(x => x === it.id);
          if (!list.length) {
            const task = new Task();
            task.type = 3;
            task.description = it.description;
            task.targetDate = new Date();
            task.remark = '';
            task.status = 100;
            task.taskName = it.subject;
            task.taskID = it.id;
            resChange.push({ data: { id: task.taskID }, task: task });
          }
        });
        if (!localStorage.getItem(cacheStorage.listTask.today)) {
          // save
          localStorage.setItem(cacheStorage.listTask.today, btoa(encodeURIComponent(JSON.stringify(this.itemSelectToDay))));
        } else {
          const today: AdapterTask[] = JSON.parse(decodeURIComponent(atob(localStorage.getItem(cacheStorage.listTask.today))));
          today.forEach(async (rx: AdapterTask, index) => {
            if (rx.task.type !== 3) {
              today[index].task.targetDate = new Date(rx.task.targetDate);
              await resChange.push(today[index]);
            }
          });
          this.itemSelectToDay = resChange;
          this.saveListTask();
        }
      });
    }
  }
  public saveRate(item, rate) {
    item.task.status = rate;
    this.saveListTask();
  }
  public connect() {
    this.socket = new SockJS(`${config.server.url}/chat`);
    this.stompClient = Stomp.over(this.socket);
    this.stompClient.debug = null;
    const that = this;
    if (localStorage.getItem(config.client.userToken)) {
      const currentUser: UserTokenState = JSON.parse(atob(localStorage.getItem(config.client.userToken)));

      this.stompClient.connect({ Authorization: `${currentUser.accessToken}` }, (frame) => {
        this.whoami = frame.headers['user-name'];
        // if (this.socket.readyState === SockJS.OPEN) {
        this.subscription = that.stompClient.subscribe('/listen-change-res/change', (ms) => {
          const data = JSON.parse(ms.body);
          console.log(data);
          if (data) {
            if (sessionStorage.getItem(cacheStorage.userService.userInfo)) {
              const userInfo: UserInfo = JSON.parse(decodeURIComponent(atob(sessionStorage.getItem(cacheStorage.userService.userInfo))));
              if (data.recipient === userInfo.userName && !this.isShowSendReport) {
                this.listenChange();
              }
            }
          }
        });
        // }
      }, (err) => {
        setTimeout(() => {
          this.connect();
        }, 5000);
        console.log(err);
      });
    }
  }
  moveUp(i) {
    if (i === 0) {
    } else {
      this.swapUp(i, this.itemSelectToDay);
    }
  }
  moveDown(i) {
    if (i >= this.itemSelectToDay.length) {
    } else {
      this.swapDown(i, this.itemSelectToDay);
    }
  }
  moveUpTomorow(i) {
    if (i === 0) {
    } else {
      this.swapUp(i, this.itemSelectTomorrow);
    }
  }
  moveDownTomorow(i) {
    if (i >= this.itemSelectTomorrow.length) {
    } else {
      this.swapDown(i, this.itemSelectTomorrow);
    }
  }

  swapUp(i, arr) {
    const temp = arr[i];
    arr[i] = arr[i - 1];
    arr[i - 1] = temp;
  }
  swapDown(i, arr) {
    const temp = arr[i];
    arr[i] = arr[i + 1];
    arr[i + 1] = temp;
  }
}
