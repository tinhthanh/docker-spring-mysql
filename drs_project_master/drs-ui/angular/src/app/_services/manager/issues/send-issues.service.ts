import { AlertType, Alert } from './../../../_models/notify/alert';
import { AlertRightService } from './../../notify/right/alert-right.service';
import { tap, catchError } from 'rxjs/operators';
import { AdapterReport } from './../../../_models/send-issues/AdapterReport';
import { AdapterTask } from './../../../_models/AdapterTask';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs/observable/of';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/observable';
import { config } from '../../../_models/config';
import { MenuLoadingService } from '../../notify/menu/menu-loading.service';

@Injectable()
export class SendIssuesService {
  pdapterReport: AdapterReport;
  constructor(private http: HttpClient, private loadMenuService: MenuLoadingService, private alertRightService: AlertRightService  ) { }
public sendReport( valueTo: Array<any>,
                    valueCC: Array<any> ,
                    subject: string, htmlSend: string ,
                     reportType: number,
                     itemSelectToDay: AdapterTask[],
                     itemSelectTomorrow: AdapterTask[], dataEtc: string): Observable<any> {
                      this.pdapterReport = new AdapterReport(valueTo, valueCC ,
                         subject, htmlSend, reportType, itemSelectToDay, itemSelectTomorrow, dataEtc );
                  this.loadMenuService.setEnable();
  return this.http.post( `${config.server.url}/reports`, this.pdapterReport.getFormSaveReport()).pipe(
        tap(() => {  this.loadMenuService.clear();   this.alertRightService.sendNotify(new Alert(AlertType.Info , 'Sucess'));
              this.alertRightService.sendNotify(new Alert(AlertType.Success , 'Save success ...')); }),
        catchError(error => {
          console.log(error);
          this.loadMenuService.clear();
        return  of([]);
        } )
  );
}
}
