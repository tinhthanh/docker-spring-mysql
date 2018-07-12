import { Alert, AlertType } from './../../../_models/notify/alert';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AlertRightService {

  private subject = new Subject<Alert>();
  constructor() { }
    sendNotify(notify: Alert) {
      notify =  this.getAlert(notify);
        this.subject.next(notify);
    }
    clearNotify() {
        this.subject.next();
    }
    getNotify(): Observable<Alert> {
        return this.subject.asObservable();
    }
   private  getAlert(alert: Alert ): Alert {
      if (!alert) {
          return;
      }
      // return css class based on alert type
      switch (alert.type) {
          case AlertType.Success :
              alert.icon = 'glyphicon-ok';
              alert.colorBg = 'p-success';
              alert.colorIcon = 'p-success-icon';
              break;
          case AlertType.Error:
             alert.icon = 'glyphicon-remove';
             alert.colorBg = 'p-error';
             alert.colorIcon = 'p-error-icon';
          break;
          case AlertType.Info:
             alert.icon = 'glyphicon-ok';
             alert.colorBg = 'p-info';
             alert.colorIcon = 'p-info-icon';

          break;
          case AlertType.Warning:
              alert.icon = 'glyphicon-question-sign';
              alert.colorBg = 'p-warrning';
              alert.colorIcon = 'p-warrning-icon';
          break;
          default:
           break ;
      }
      return alert;
  }

}
