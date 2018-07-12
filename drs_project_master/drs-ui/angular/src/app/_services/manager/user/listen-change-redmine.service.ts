import { tap } from 'rxjs/operators';
import { config } from './../../../_models/config';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ListenChangeRedmineService {

  constructor(private http: HttpClient) {
   }
   public updateChange(): Observable<any> {
     return this.http.get(`${config.server.url}/issue_trackers/today`).pipe(
       tap( res => {} )
      );
   }

}
