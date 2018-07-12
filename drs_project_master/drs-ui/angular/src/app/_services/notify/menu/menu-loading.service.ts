import { NotifyCenter } from './../../../_models/notify/notify-center';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';
import { Observable } from 'rxjs/Observable';
@Injectable()
export class MenuLoadingService {
  private subject = new Subject<boolean>();
  constructor() { }
    setEnable() {
        this.subject.next(true);
    }
    clear() {
        this.subject.next();
    }
    notify(): Observable<boolean> {
        return this.subject.asObservable();
    }

}
