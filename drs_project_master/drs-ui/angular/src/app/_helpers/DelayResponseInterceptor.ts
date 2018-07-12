import { config } from './../_models/config';
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
@Injectable()
export class DelayResponseInterceptor implements HttpInterceptor {
  constructor() { }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
          return Observable.of(null).mergeMap(() => {
            console.log(`Time delay response ...  ${config.server.delay}`) ;
        return next.handle(request);
        }).materialize()
            .delay(config.server.delay)
            .dematerialize();
      }

}
export let  FakeTimeResponse = {
  provide: HTTP_INTERCEPTORS,
  useClass: DelayResponseInterceptor,
  multi: true
};
