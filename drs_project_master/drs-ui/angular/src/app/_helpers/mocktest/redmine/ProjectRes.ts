import { fakeProjects } from './../fake-data/fake-projects';
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
@Injectable()
export class ProjectResInterceptor implements HttpInterceptor {
    constructor() { }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
            const projects = fakeProjects;
              return Observable.of(null).mergeMap(() => {
                if (config.mockRes.projectRes || config.mockRes.status) {
                    console.log(request.url);
                if (request.url.endsWith('/redmine/projects') && request.method === 'GET') {
                    // if (projects.length !== 2) {
                    //     console.log(request.url) ;
                        return Observable.of(new HttpResponse({ status: 200, body: projects}));
                    // } else {
                    //     return Observable.throw(new HttpErrorResponse({ status: 409, statusText: 'Xóa không thành công' }));
                    // }
                }
            }
                return next.handle(request);
            }).materialize()
                .delay(0)
                .dematerialize();
          }
    }
    export let  ProjectRes = {
        provide: HTTP_INTERCEPTORS,
        useClass: ProjectResInterceptor,
        multi: true
    };
