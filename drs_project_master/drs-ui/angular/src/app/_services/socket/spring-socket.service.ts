import { cacheStorage } from './../../_cache/cacheStorage';
import { UserInfo } from './../../_models/user/user-info';
import { filter } from 'rxjs/operator/filter';
import { config } from './../../_models/config';
import { UserTokenState } from './../../_models/user/user-token-state';
import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import { error } from 'protractor';
import { NotifyContent } from '../../_models/user/notify-content';
import { ListenDataService } from './listen-data.service';
@Injectable()
export class SpringSocketService {
  constructor(private listenDataService: ListenDataService ) {
    // setTimeout(() => { this.connect(); }, 1000);
  }

  private stompClient = null;
  socket = null;
  whoami = null;
  public connect() {
    this.socket = new SockJS(`${config.server.url}/chat`);
    this.stompClient = Stomp.over(this.socket);
    this.stompClient.debug = null;
    const that = this;
    if (localStorage.getItem(config.client.userToken)) {
      const currentUser: UserTokenState = JSON.parse(atob(localStorage.getItem(config.client.userToken)));

      this.stompClient.connect({ Authorization: `${currentUser.accessToken}` }, (frame) => {
        this.whoami = frame.headers['user-name'];
        if (this.socket.readyState === SockJS.OPEN) {
          that.stompClient.subscribe('/user/queue/messages', (message) => {
            this.listenDataService.sendMessenger(JSON.parse(message.body));
          });
          that.stompClient.subscribe('/topic/active', (activeMembers) => {
            if (this.socket.readyState === SockJS.OPEN) {
              this.pingServer();
            }
            if ( sessionStorage.getItem(cacheStorage.userService.userInfo) ) {
              if (activeMembers.body) {
                const userOnlie: string[] = JSON.parse(activeMembers.body);
                const userInfo: UserInfo = JSON.parse(decodeURIComponent(atob(sessionStorage.getItem(cacheStorage.userService.userInfo))));
                const myUser = userOnlie.filter(x => x === this.whoami);
                if (!(myUser.length >= 1)) {
                  this.connect();
                }
              } else {
                this.connect();
              }
              this.listenDataService.sendUserOnline(activeMembers.body);
            }
          });
          that.stompClient.subscribe('/listen-change-res/change', (ms) => {
            this.listenDataService.sendMessenger(JSON.parse(ms.body));
              // console.log(ms);
          });
        }
      }, (err) => {
        setTimeout(() => {
          this.connect();
        }, 5000);
        console.log(err);
      });
    }
  }
  public closeConnection() {
    this.socket.close();
  }
  public pingServer() {
    if (localStorage.getItem(config.client.userToken)) {
      const currentUser: UserTokenState = JSON.parse(atob(localStorage.getItem(config.client.userToken)));
      this.stompClient.send('/app/activeUsers', { Authorization: `${currentUser.accessToken}` }, '');
    }
  }
  public sendMessageTo(user: string, message: string) {
    if (!message.length) {
      return;
    } else
      if (localStorage.getItem(config.client.userToken)) {
        const content = new NotifyContent();
        content.id = Math.floor((Math.random() * 1000000) + 100000);
        content.dateTo = new Date().getTime();
        content.dateView = new Date().getTime();
        content.body = message;
        content.status = 1; // staus 1 change redmine
        content.title = 'Update task report...';
        content.userSend = this.whoami;
        const currentUser: UserTokenState = JSON.parse(atob(localStorage.getItem(config.client.userToken)));
        this.stompClient.send('/app/chat', { Authorization: `${currentUser.accessToken}` }, JSON.stringify({
          'recipient': user,
          'message': content
        }));
      }
  }
}
