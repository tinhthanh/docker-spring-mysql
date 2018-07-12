import { PagerServiceService } from './../../../_services/manager/pagerservice/pager-service.service';
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
import { issues } from '../fake-data/fake-issues';
import { config } from '../../../_models/config';
@Injectable()
export class IssuesResInterceptor implements HttpInterceptor {
    constructor(private pagesding: PagerServiceService) { }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
              return Observable.of(null).mergeMap(() => {
                  if (config.mockRes.issuesRes || config.mockRes.status) {
                    if ( request.url.match(/\/api\/issues\?page=([0-9]{1,9})&size=([0-9]{1,9})/) && request.method === 'GET') {
                        const nextData = request.url.match(/\/api\/issues\?page=([0-9]{1,9})&size=([0-9]{1,9})/);
                        const pager = this.pagesding.getPager(issues.length , Number(nextData[1]) , Number(nextData[2]) );
                           return Observable.of(new HttpResponse({
                                           status: 200, body: {
                                            total_count: issues.length ,
                                            limit: nextData[2],
                                            data:  issues.slice(pager.startIndex, pager.endIndex + 1) } }));
                         //   return Observable.throw(new HttpErrorResponse({ status: 409, statusText: '' }));
                    }
                  }
                return next.handle(request);
            }).materialize()
                .delay(0)
                .dematerialize();
          }
    }
    export let  IssuesRes = {
        provide: HTTP_INTERCEPTORS,
        useClass: IssuesResInterceptor,
        multi: true
    };
