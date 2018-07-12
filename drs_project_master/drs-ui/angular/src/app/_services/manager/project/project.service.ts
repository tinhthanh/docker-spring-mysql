import { of } from 'rxjs/observable/of';
import { config } from './../../../_models/config';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
@Injectable()
export class ProjectService {

  constructor(private http: HttpClient) { }
  public getAllProject(): Observable<any[]> {
    if (localStorage.getItem(config.client.userToken)) {
    return this.http.get<any[]>(`${config.server.url}/redmine/projects`);
    } else {
      return of([]);
    }
}
}
