import { of } from 'rxjs/observable/of';
import { Alert, AlertType } from './../../../_models/notify/alert';
import { AlertRightService } from './../../notify/right/alert-right.service';
import { tap, catchError } from 'rxjs/operators';
import { MenuLoadingService } from './../../notify/menu/menu-loading.service';
import { config } from './../../../_models/config';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { ReportItem } from '../../../_models/report/ReportItem';
@Injectable()
export class ReportService {

  constructor(private http: HttpClient, private menuLoadingService: MenuLoadingService, private alertRightService: AlertRightService) { }
  public getReportSave(page: number = 1, pageSize: number = 5, userId: number = -1 ): Observable<any[]> {
    const id = (userId !== -1 ) ? '&userId=' + userId : '';
    return this.http.get<any[]>(`${config.server.url}/reports?page=${page}&pageSize=${pageSize}&reportType=1${id}`);
  }
  public getReportSend(page: number = 1, pageSize: number = 5,  userId: number = -1): Observable<any> {
    const id = (userId !== -1 ) ? '&userId=' + userId : '';
    return this.http.get<any>(`${config.server.url}/reports?page=${page}&pageSize=${pageSize}&reportType=2${id}`);
  }
  public getReportById(id: number): Observable<ReportItem> {
    return this.http.get<ReportItem>(`${config.server.url}/reports/${id}`);
  }

  public deleteTaskById(taskId: number): Observable<any> {
    this.menuLoadingService.setEnable();
    return this.http.delete<any>(`${config.server.url}/tasks/${taskId}`)
      .pipe(
        tap((res) => {
          this.menuLoadingService.clear();
          console.log(res);
          this.alertRightService.sendNotify(new Alert(AlertType.Success, 'Delete task Success ...'));
        }), catchError((err) => {
          this.menuLoadingService.clear();
          return of({});
        }));

  }
  // delete report by id
  public deleteReportSaved(reportId: number) {
    this.menuLoadingService.setEnable();
    return this.http.delete<any>(`${config.server.url}/reports/${reportId}`)
      .pipe(
        tap((res) => {
          this.menuLoadingService.clear();
          console.log(res);
          this.alertRightService.sendNotify(new Alert(AlertType.Success, 'Delete task Success ...'));
        }), catchError((err) => {
          this.menuLoadingService.clear();
          return of({});
        }));

  }
}
