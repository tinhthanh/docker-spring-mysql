import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import { UserInfo } from '../../../_models/user/user-info';
@Injectable()
export class NotifyLoginService {
  private subject = new Subject<UserInfo>();
  constructor() { }
    sendNotify(userInfo: UserInfo) {
        this.subject.next(userInfo);
    }
    clearNotify() {
        this.subject.next();
    }
    getInfo(): Observable<UserInfo> {
        return this.subject.asObservable();
    }
}
