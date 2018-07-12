import {HttpParams} from '@angular/common/http';
import { of } from 'rxjs/observable/of';
import { tap, catchError } from 'rxjs/operators';
import { UserInfo } from './../../_models/user/user-info';
import { Observable } from 'rxjs/Observable';
import { config } from './../../_models/config';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserRoleList } from '../../_models/user/user-role';
import { Privilege } from '../../_models/user/privilege';

@Injectable()
export class ManagerRoleService {
  constructor(private http: HttpClient) { }

  public getAllPrivilegeById(id) {
    return  this.http.get<Privilege[]>(`${config.server.url}/admin/privileges/` + id);
  }
    public getByUser(id: number): Observable<Privilege[]> {
        return this.http.get<Privilege[]>(`${config.server.url}/admin/privileges/view-by-user/${id}`);
    }
  public deletePrivilege(id) {
    return this.http.delete<Boolean>(`${config.server.url}/admin/privileges/` + id);
  }

  public addPrivilege(privilege) {
    return this.http.post<any>(`${config.server.url}/admin/privileges`, privilege);
  }
  public getAllUserWithRole(offset, limit): Observable<UserRoleList> {
    let params = new HttpParams();
    params = params.append('offset', offset );
    params  = params.append('limit', limit);
    return this.http.get<UserRoleList>(`${config.server.url}/admin/get-all-user-and-roles`, {params: params});
  }

  public getAllUser(): Observable<UserInfo[]> {
    return this.http.get<UserInfo[]>(`${config.server.url}/admin/get-all-users`);
  }
  public getStatus(status: number): Observable<any> {
    return this.http.get<any>( `${config.server.url}/admin/role/status/${status}`).pipe(
      tap(data => { console.log(data); } ),
      catchError(error => {
        console.log(error);
      return  of([]);
      } )
    );
  }
}
