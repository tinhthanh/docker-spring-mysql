import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
@Injectable()
export class ListenDataService {
  private userOnline = new Subject<any>();
  private messenger = new Subject<any>();
  constructor() { }
  sendUserOnline(message: any) {
    this.userOnline.next(message);
  }
  clear() {
    this.userOnline.next();
  }
  getAllUser(): Observable<any> {
    return this.userOnline.asObservable();
  }

  sendMessenger(message: any) {
    this.messenger.next(message);
  }
  clearMessenger() {
    this.messenger.next();
  }
  getAllMessenger(): Observable<any> {
    return this.messenger.asObservable();
  }
}
