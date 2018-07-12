import { tap } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { cacheStorage } from './../../../_cache/cacheStorage';
import { Observable } from 'rxjs/Observable';
import { config } from './../../../_models/config';
import { UserInfo } from './../../../_models/user/user-info';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }
  public getUserInfo(): Observable<UserInfo> {
    if (localStorage.getItem(config.client.userToken)) {
      if (sessionStorage.getItem(cacheStorage.userService.userInfo)) {
        const userInfo: UserInfo = JSON.parse(decodeURIComponent(atob(sessionStorage.getItem(cacheStorage.userService.userInfo))));
        return of(userInfo);
      } else {
        return this.http.get<UserInfo>(`${config.server.url}/user/info`).pipe(
          // localStorage.setItem(config.client.info, btoa(encodeURIComponent(JSON.stringify(result))));
          tap((res: UserInfo) => {
            sessionStorage.setItem(cacheStorage.userService.userInfo, btoa(encodeURIComponent(JSON.stringify(res))));
          })
        );
      }
    } else {
      return of(null);
    }
  }
  public getAllUser(): Observable<any> {
    if (localStorage.getItem(config.client.userToken)) {
      if (sessionStorage.getItem(cacheStorage.userService.allUserRedmine)) {
        const listUsers = JSON.parse(decodeURIComponent(atob(sessionStorage.getItem(cacheStorage.userService.allUserRedmine))));
        return of(listUsers);
      } else {
        return this.http.get(`${config.server.url}/redmine/users`).pipe(
          tap(res => sessionStorage.setItem(cacheStorage.userService.allUserRedmine, btoa(encodeURIComponent(JSON.stringify(res)))))
        );
      }
    } else {
      return of([]);
    }
  }
}
