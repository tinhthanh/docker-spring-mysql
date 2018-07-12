import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { config} from '../_models/config';
import { UserTokenState } from '../_models/user/user-token-state';
import { AuthService } from '../_services/manager/user/auth.service';
@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private authSv: AuthService) {}
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (localStorage.getItem(config.client.userToken)) {
            const currentUser: UserTokenState = JSON.parse(atob(localStorage.getItem(config.client.userToken)));
            const generateTime = Date.parse(`${currentUser.generateTime}`);
            const expire = currentUser.expireAfter * 0.9 * 1000;
            const now = new Date();
            if ( generateTime + expire  <= now.getTime()) {
                if ( !(request.method === 'GET'  && request.url.endsWith('/auth/refresh') )) {
                this.authSv.refresh();
                }
            }
            console.log(request.url + ' JWT');
            if ( currentUser ) {
                request = request.clone({
                    setHeaders: {
                        Authorization: `${currentUser.tokenType} ${currentUser.accessToken}`
                    }
                });
            }
         }
        return next.handle(request);
    }
}

export let  JwtFilter = {
    provide: HTTP_INTERCEPTORS,
    useClass: JwtInterceptor,
    multi: true
};
