import { of } from 'rxjs/observable/of';
import { config } from './../../../_models/config';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { tap, catchError } from 'rxjs/operators';
import { MenuLoadingService } from '../../notify/menu/menu-loading.service';
@Injectable()
export class IssuesService {

  constructor(private http: HttpClient, private loadingMenu: MenuLoadingService) { }
      public getAllIssues(offset = 0 , limit = 10): Observable<any[]> {
        this.loadingMenu.setEnable() ;
  return this.http.get<any[]>(`${config.server.url}/redmine/issues?offset=${offset}&limit=${limit}`).pipe(
    tap( () => { this.loadingMenu.clear(); }),
        catchError( (err) => {
          console.error(err);
          this.loadingMenu.clear();
          return of([]);
        })
     );
}
  public getIssuesById(id: number): Observable<any[]> {
    return this.http.get<any[]>(`${config.server.url}/redmine/issues/filter?issue_id=${id}`);
  }
  public filter(filter: string): Observable<any[]> {
    this.loadingMenu.setEnable() ;
    return this.http.get<any[]>(`${config.server.url}/redmine/issues/filter?${filter}`).pipe(
       tap( () => { this.loadingMenu.clear(); }),
       catchError( (err) => {
         this.loadingMenu.clear();
         return of([]);
       })
    );
  }
}
