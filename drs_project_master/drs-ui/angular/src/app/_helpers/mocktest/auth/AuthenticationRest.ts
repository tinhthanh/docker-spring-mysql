import { config } from './../../../_models/config';
import { HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/delay';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/operator/materialize';
import 'rxjs/add/operator/dematerialize';
import { filter } from 'rxjs/operator/filter';
import { DataUser } from './DataUser';
@Injectable()
export class AuthenticationRestInterceptor implements HttpInterceptor {
    public data: DataUser = new DataUser();
    constructor( ) { }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        this.data.load();
        const users: any[] = this.data.users;
        console.log(users);
              return Observable.of(null).mergeMap(() => {
                if (request.url.endsWith('/auth/login') && request.method === 'POST') {
                    const filteredUsers = users.filter((user: any) => {
                        return user.email === request.body.email && user.password === request.body.password;
                    });
                    console.log(request.body);
                    console.log(filteredUsers);
                    if (filteredUsers.length) {
                        const user = filteredUsers[0];
                        const body = {
                            access_token: request.body.email ,
                            expires_in: 600
                        };
                        return Observable.of(new HttpResponse({ status: 200, body: body }));
                    } else {
                        return Observable.throw(new HttpErrorResponse({status: 403, statusText: 'User invali '}));
                    }
                }
                if (request.url.endsWith('/auth/refresh') && request.method === 'GET') {
                    if (this.data.checkToken(request.headers.get('Authorization')) ) {
                        console.log('SERVER refresh TOKEN');
                        const body = {
                            access_token: request.headers.get('Authorization'),
                            expires_in: 600
                        };
                        return Observable.of(new HttpResponse({ status: 200, body: users }));
                    } else {
                        // return 401 not authorised if token is null or invalid
                        return Observable.throw(  new HttpErrorResponse({status: 403, statusText: 'token is null or s'}));
                    }
                }
            return next.handle(request);
            }).materialize()
                .delay(0)
                .dematerialize();
          }
        }
export let AuthenticationRest = {
  // sử dụng phụ trợ giả để thay thế cho dịch vụ Http để phát triển phụ trợ
  provide: HTTP_INTERCEPTORS,
  useClass: AuthenticationRestInterceptor,
  multi: true
};
