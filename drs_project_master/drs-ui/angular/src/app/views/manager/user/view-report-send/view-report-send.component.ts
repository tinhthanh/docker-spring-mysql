import { Privilege } from './../../../../_models/user/privilege';
import { Observable } from 'rxjs/Observable';
import { config } from './../../../../_models/config';
import { AlertType, Alert } from './../../../../_models/notify/alert';
import { Task } from './../../../../_models/Task';
import { ReportService } from './../../../../_services/manager/report/report.service';
import { Component, OnInit } from '@angular/core';
import { ReportItem } from '../../../../_models/report/ReportItem';
import { PagerServiceService } from '../../../../_services/manager/pagerservice/pager-service.service';
import { CustomTask } from '../../../home/issues-projects/models/CustomTask';
import { cacheStorage } from '../../../../_cache/cacheStorage';
import { AdapterTask } from '../../../../_models/AdapterTask';
import { AlertRightService } from '../../../../_services/notify/right/alert-right.service';
import { Router } from '@angular/router';
import { UserInfo } from '../../../../_models/user/user-info';
import { ManagerRoleService } from '../../../../_services/admin/manager-role.service';

@Component({
  selector: 'app-view-report-send',
  templateUrl: './view-report-send.component.html',
  styleUrls: ['./view-report-send.component.css']
})
export class ViewReportSendComponent implements OnInit {
  isLoading = false; // loading button page
  pager: any = {};
  report: any ;
  public listReport: ReportItem[]  = [];
  itemSelectToDay: any ;
  itemSelectTomorrow: any ;
  userId = -1 ;
  listSelect: Observable<Privilege[]> ;
  constructor(private reportService: ReportService,
    private pagerServiceService: PagerServiceService,
    private alertRightService: AlertRightService,
    private managerRoleService: ManagerRoleService,
    private router: Router) {
      if (!localStorage.getItem(config.client.userToken)) {
        this.router.navigate(['/dashboard/login']);
      }
     }

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
    this.reportService.getReportSend(page, size,  this.userId).subscribe( (data: any ) => {
      console.log(data);
      if ( data.listOfReports && data.listOfReports.length !== 0) {
        this.listReport =  data.listOfReports;
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
    this.reportService.getReportById(id).subscribe( ( data: ReportItem ) => {
      this.listReport.forEach( (item: ReportItem , index)  => {
            if ( item.report_id === id ) {
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
  public forkTaskInSavedReport(item: CustomTask) {
    console.log(item);
    const today = new Task() ;
          today.type = 2 ;
          today.description = item.description ;
          today.remark = item.remark ;
          today.status = item.status ;
          today.targetDate =  new Date(item.targetDate);
          today.targetDate.setHours(12);
          today.taskName = item.taskName ;
          console.log(today);
      if ( item.taskDateDefined === 1  ||  item.taskDateDefined === 2) {
        if (!localStorage.getItem(cacheStorage.listTask.today)) {
          // save
          localStorage.setItem(cacheStorage.listTask.today, btoa(encodeURIComponent(JSON.stringify([]))));
        } else {
          const listToday: AdapterTask[] =  JSON.parse(decodeURIComponent(atob(localStorage.getItem(cacheStorage.listTask.today))));
          today.taskID  = Math.floor((Math.random() * 10000000) + 1000000) ;
          listToday.push({ data: { id: today.taskID } , task:  today});
         localStorage.setItem(cacheStorage.listTask.today, btoa(encodeURIComponent(JSON.stringify(listToday))));
        }
      } else if ( item.taskDateDefined === 2) {
      }
      this.alertRightService.sendNotify(new Alert(AlertType.Success, 'Fork task Success ...'));
  }
  public changeSelectUser(t) {
    this.userId = Number(t.value) ;
    this.setPage(1);
  }

}
