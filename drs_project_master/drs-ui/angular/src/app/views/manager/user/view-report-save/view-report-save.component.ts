import { Privilege } from './../../../../_models/user/privilege';
import { Observable } from 'rxjs/observable';
import { Alert, AlertType } from './../../../../_models/notify/alert';
import { AdapterTask } from './../../../../_models/AdapterTask';
import { cacheStorage } from './../../../../_cache/cacheStorage';
import { Task } from './../../../../_models/Task';
import { CustomTask } from './../../../home/issues-projects/models/CustomTask';
// import { ShareIssuesService } from './../../../../_services/manager/shared/share-issues.service';
import { config } from './../../../../_models/config';
import { PagerServiceService } from './../../../../_services/manager/pagerservice/pager-service.service';
import { ReportItem } from './../../../../_models/report/ReportItem';
import { ReportService } from './../../../../_services/manager/report/report.service';
import { Component, OnInit } from '@angular/core';
import { AlertRightService } from '../../../../_services/notify/right/alert-right.service';
import { Router } from '@angular/router';
import { ManagerRoleService } from '../../../../_services/admin/manager-role.service';
import { UserInfo } from '../../../../_models/user/user-info';


const DAYS = ['SUNDAY', 'MONDAY', 'TUSEDAY', 'WEDNESDAY', 'THUSRDAY', 'FRIDAY', 'SATURDAY'];
const MONTHS = ['JANUARY', 'FEBRUARY', 'MARCH', 'APRIL', 'MAY', 'JUNE', 'JULY', 'AUGUST', 'SEPTEMBER', 'OCTOBER', 'NOVEMBER', 'DECEMBER'];
@Component({
  selector: 'app-view-report-save',
  templateUrl: './view-report-save.component.html',
  styleUrls: ['./view-report-save.component.css']
})
export class ViewReportSaveComponent implements OnInit {
  isLoading = false; // loading button page
  pager: any = {};
  report: any;
  public listReport: ReportItem[] = [];
  itemSelectToDay: any;
  itemSelectTomorrow: any;
  listSelect: Observable<Privilege[]> ;
  userId = -1 ;
  constructor(private reportService: ReportService,
    private pagerServiceService: PagerServiceService,
    // private shareIssuesService: ShareIssuesService
    private alertRightService: AlertRightService,
    private managerRoleService: ManagerRoleService,
    private router: Router,
  ) {
    if (!localStorage.getItem(config.client.userToken)) {
      this.router.navigate(['/dashboard/login']);
    }
  }
  editState = false;
  reportSaveItem: Task;

  ngOnInit() {
    this.setPage(1);
    if (sessionStorage.getItem(cacheStorage.userService.userInfo) ) {
      const userInfo: UserInfo = JSON.parse(decodeURIComponent(atob(sessionStorage.getItem(cacheStorage.userService.userInfo))));
      this.listSelect =   this.managerRoleService.getByUser(userInfo.userId);
    }
  }
  setPage(page: number) {
    this.isLoading = true;
    const size = 10;
    if (page < 1 || page > this.pager.totalPages) {
      return;
    }
    // get pager object from service
    const offset = (page - 1) * size;
    const limit = size;
    this.reportService.getReportSave(page, size, this.userId ).subscribe((data: any) => {
      console.log(data);
      if (data.listOfReports && data.listOfReports.length !== 0) {
        this.listReport = data.listOfReports;
        this.getReportById(this.listReport[0].report_id);
        this.pager = this.pagerServiceService.getPager(data.totalRecords, page, size);
      } else {
        this.alertRightService.sendNotify(new Alert(AlertType.Success, 'No data ...'));
      }
      this.isLoading = false;
    });
  }
  public toStringDate(date): string {
    const ng: number = date;
    const temp = new Date(ng);
    return `${temp.getMonth() + 1}/${temp.getDate()}/${temp.getFullYear()}`;
  }
  public getReportById(id: number) {
    this.reportService.getReportById(id).subscribe((data: ReportItem) => {
      this.listReport.forEach((item: ReportItem, index) => {
        if (item.report_id === id) {
          this.listReport[index].isCheck = 2;
        } else {
          this.listReport[index].isCheck = 1;
        }
      });
      console.log(data);
      this.report = data;
      this.itemSelectToDay = this.report.tasks;
      this.itemSelectTomorrow = this.report.tasks;
    });
  }

  // delete task in saved report
  public deleteTaskInSavedReport($event) {
    let taskId: number;
    taskId = $event.taskId;
    console.log(taskId);
    this.reportService.deleteTaskById(taskId).subscribe((res: any) => {
      console.log(res);
    });
    $event.statusHide = -1;
  }

  // delete report saved
  public deleteReportSaved($event) {
    const reportId = $event.report_id;
    console.log($event);
    console.log(reportId);
    this.reportService.deleteReportSaved(reportId).subscribe((res: any) => {
      console.log(res);
      $event.report_id = -1;
    });

  }
  // fork report
  public forkTaskInSavedReport(item: CustomTask) {
    console.log(item);
    const today = new Task();
    today.type = 2;
    today.description = item.description;
    today.remark = item.remark;
    today.status = item.status;
    today.targetDate = new Date(item.targetDate);
    today.targetDate.setHours(12);
    today.taskName = item.taskName;
    console.log(today);
    if (item.taskDateDefined === 1 || item.taskDateDefined === 2) {
      if (!localStorage.getItem(cacheStorage.listTask.today)) {
        // save
        localStorage.setItem(cacheStorage.listTask.today, btoa(encodeURIComponent(JSON.stringify([]))));
      } else {
        const listToday: AdapterTask[] = JSON.parse(decodeURIComponent(atob(localStorage.getItem(cacheStorage.listTask.today))));
        today.taskID = Math.floor((Math.random() * 10000000) + 1000000);
        listToday.push({ data: { id: today.taskID }, task: today });
        localStorage.setItem(cacheStorage.listTask.today, btoa(encodeURIComponent(JSON.stringify(listToday))));
      }
    } else if (item.taskDateDefined === 2) {
    }
    this.alertRightService.sendNotify(new Alert(AlertType.Success, 'Fork task Success ...'));

    // if (!localStorage.getItem(config.client.listTaskFork)) {
    //   localStorage.setItem(config.client.listTaskFork, JSON.stringify([]));
    // }
    // const listOfTaskForks: CustomTask[] = JSON.parse(localStorage.getItem(config.client.listTaskFork));
    // listOfTaskForks.push(item);
    // localStorage.setItem(config.client.listTaskFork, JSON.stringify(listOfTaskForks));
    // this.shareIssuesService.sendChage(true);
  }
  public localTimeToDate(date): string {
    return `${date.monthValue}/${date.dayOfMonth}/${date.year}`;
  }
  editSaveReportItem(item) {
    this.editState = true;
    this.reportSaveItem = item;
  }
  hideEditReport(event) {
    this.editState = event;
  }
  public update($event) {
    const targetDate = new Date($event.target_date);
    this.itemSelectToDay.forEach((item: any) => {
      if (item.taskId === $event.task_id) {
        item.taskName = $event.task_name;
        item.description = $event.description;
        item.remark = $event.remark;
        item.status = $event.task_status;
        item.target_date = item.targetDate = $event.target_date;
      }
    });
  }

  public dayOfYear(date: Date): number {
    const start = new Date(date.getFullYear(), 0, 0);
    const diff = (date.getTime() - start.getTime()) + ((start.getTimezoneOffset() - date.getTimezoneOffset()) * 60 * 1000);
    const oneDay = 1000 * 60 * 60 * 24;
    const day = Math.floor(diff / oneDay);
    return day;
  }
  public leapYear(year) {
    return ((year % 4 === 0) && (year % 100 !== 0)) || (year % 400 === 0);
  }
  public changeSelectUser(t) {
    this.userId = Number(t.value) ;
    this.setPage(1);
  }
}
