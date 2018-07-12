import { AuthGuardAdmin } from './../../../_guards/AuthGuardAdmin';
import { NotifyLoginService } from './notify-login.service';
import { UserService } from './user.service';
import { UserTokenState } from './../../../_models/user/user-token-state';
import { config } from './../../../_models/config';
import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { tap, catchError } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { UserInfo } from '../../../_models/user/user-info';
import { Role } from '../../../_models/user/role';
@Injectable()
export class AuthService {

  constructor(private http: HttpClient,
              private userService: UserService,
              private notifyInfoService: NotifyLoginService,
              private authGuardAdmin: AuthGuardAdmin  ) { }
  public authLogin(userName: string, password: string): Observable<UserTokenState> {
    const url = `${config.server.url}/auth/login`;
    // console.log(url);
    const requestBody: any = {};
    requestBody.userName = userName;
    requestBody.password = password;
    return this.http.post<any>(url, requestBody).pipe(
      tap(data => {
        // save json web token to local storage
        localStorage.setItem(config.client.userToken, btoa(JSON.stringify(data)));
        this.userService.getUserInfo().subscribe( (result: UserInfo) => {
          this.notifyInfoService.sendNotify(result);
          localStorage.setItem(config.client.info, btoa(encodeURIComponent(JSON.stringify(result))));
        });

      })
    );

  }
  public refresh() {
    const urlRefresh = `${config.server.url}/auth/refresh`;
    return this.http.get<any>(urlRefresh).subscribe(data => {
      localStorage.setItem(config.client.userToken, btoa(JSON.stringify(data)));
    });
}

}
