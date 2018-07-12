import { NotifyCenter } from './../../../_models/notify/notify-center';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class NotifyCenterService {
  private subject = new Subject<NotifyCenter>();
  constructor() { }
    sendNotifyCenter(notifyCenter: NotifyCenter) {
        this.subject.next(notifyCenter);
    }
    clearNotifyCenter() {
        this.subject.next();
    }
    getNotifyCenter(): Observable<NotifyCenter> {
        return this.subject.asObservable();
    }
}
