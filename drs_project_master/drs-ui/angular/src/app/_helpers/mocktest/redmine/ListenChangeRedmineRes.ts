import { data } from './../fake-data/listenFake';
import { Project } from './../../../_models/redmine-api/Project';
import { DataProject } from './DataProject';
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
import { config } from '../../../_models/config';
@Injectable()
export class ListenChangeRedmineInterceptor implements HttpInterceptor {
    constructor() { }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
              return Observable.of(null).mergeMap(() => {
                 
                    if ( request.url.endsWith('/listen-change-redmine') && request.method === 'GET') {
                           return Observable.of(new HttpResponse({
                                           status: 200, body: data.slice( 0, Math.floor((Math.random() * 5) + 1 ) ) }));
                         //   return Observable.throw(new HttpErrorResponse({ status: 409, statusText: '' }));
                    }
                return next.handle(request);
            }).materialize()
                .delay(0)
                .dematerialize();
          }
    }
    export let  ListenChangeRedmineRes = {
        provide: HTTP_INTERCEPTORS,
        useClass: ListenChangeRedmineInterceptor,
        multi: true
    };
