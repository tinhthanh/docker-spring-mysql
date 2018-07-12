import { cacheStorage } from './../../../_cache/cacheStorage';
import { ListenChangeRedmineService } from './../../../_services/manager/user/listen-change-redmine.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, Input } from '@angular/core';
import { NotifyContent } from '../../../_models/user/notify-content';
import { ListenDataService } from '../../../_services/socket/listen-data.service';
import { UserInfo } from '../../../_models/user/user-info';

@Component({
  selector: 'app-socket-notify',
  templateUrl: './socket-notify.component.html',
  styleUrls: ['./socket-notify.component.css']
})
export class SocketNotifyComponent implements OnInit {
  @Input() isShowInfomation: boolean;
  @Input() isShowNotify: boolean;
  messenger: any[] = [];
  userOnline: any;
  model: any = { user: '', messenger: '' };
  expires = new Date();
  constructor(private listenDataService: ListenDataService) {
    this.listenDataService.getAllUser().subscribe((userOnline: any) => {
      // console.log(res);
      this.userOnline = JSON.parse(userOnline);
    }, (err: HttpErrorResponse) => {
      console.log(err);
    });
    this.listenDataService.getAllMessenger().subscribe((res: any) => {
      // console.log(res);
      if (sessionStorage.getItem(cacheStorage.userService.userInfo) ) {
        const userInfo: UserInfo = JSON.parse(decodeURIComponent(atob(sessionStorage.getItem(cacheStorage.userService.userInfo))));
        if (res.recipient === userInfo.userName) {
          const notifyConten: NotifyContent = res.message;
          const date = new Date(notifyConten.dateTo);
          if (date.getTime() > this.expires.getTime() + cacheStorage.cache.time) {
            notifyConten.dateTo = date;
            this.messenger.push(notifyConten);
            this.expires = date;
          }
        }
      }
    });
  }
  sendMessenger() {
    // this.listenDataService.sendMessageTo(this.model.user, this.model.messenger);
  }

  ngOnInit() {

  }

}
