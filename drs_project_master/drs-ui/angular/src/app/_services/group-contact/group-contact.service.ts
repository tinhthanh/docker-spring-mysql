import { AlertType, Alert } from './../../_models/notify/alert';
import { AlertRightService } from './../notify/right/alert-right.service';
import { MenuLoadingService } from './../notify/menu/menu-loading.service';
import { of } from 'rxjs/observable/of';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators/tap';
import { catchError } from 'rxjs/operators/catchError';
import { config } from '../../_models/config';
import { map } from 'rxjs/operators';


@Injectable()
export class GroupContactService {

  constructor(private http: HttpClient, private menuLoadingService: MenuLoadingService, private alertRightService: AlertRightService) { }

  public getGroupContacts(): Observable<any> {
    return this.http.get<any>(`${config.server.url}/group_contacts?page=1&pageSize=100`).pipe(
      tap((res) => { console.log(res); }),
      catchError((err) => {
        return of({});
      })
    );
  }
  // filter
  public getGroupContactsById(group_contact_id: number): Observable<any> {

    return this.http.get<any>(`${config.server.url}/group_contacts/${group_contact_id}`).pipe(
      tap((res) => { console.log(res); }),
      map(res => this.convertCard(res)),
      catchError((err) => {
        return of({});
      })
    );
  }
  // not filter
  public getGroup(group_contact_id: number): Observable<any> {
    this.menuLoadingService.setEnable();
    return this.http.get<any>(`${config.server.url}/group_contacts/${group_contact_id}`).pipe(
      tap((res) => { this.menuLoadingService.clear(); console.log(res); }),
      catchError((err) => {
        return of({});
      })
    );
  }
  // add group
  public addGroupContact(name: string): Observable<any> {
    this.menuLoadingService.setEnable();
    return this.http.post<any>(`${config.server.url}/group_contacts`, {
      groupContactName: name
    }).pipe(
      tap((res) => { this.menuLoadingService.clear(); console.log(res); }),
      catchError((err) => {
        return of({});
      })
    );
  }
  // {
  //   "groupContactId": 0,
  //   "groupContactName": ""
  // }
  public deleteContact(id: number): Observable<any> {
    this.menuLoadingService.setEnable();
    return this.http.delete<any>(`${config.server.url}/group_contact_contents/${id}`).pipe(
      tap((res) => {
        this.menuLoadingService.clear(); console.log(res);
        this.alertRightService.sendNotify(new Alert(AlertType.Success, 'Delete contact success ...'));
      }),
      catchError((err) => {
        return of({});
      })
    );
  }
  public deleteGroup(id: number): Observable<any> {
    this.menuLoadingService.setEnable();
    return this.http.delete<any>(`${config.server.url}/group_contacts/${id}`).pipe(
      tap((res) => {
        this.menuLoadingService.clear(); console.log(res);
        this.alertRightService.sendNotify(new Alert(AlertType.Success, 'Delete Group success ...'));
      }),
      catchError((err) => {
        return of({});
      })
    );
  }
  public editContact(id: number, name: string): Observable<any> {
    console.log(id);
    console.log(name);
    this.menuLoadingService.setEnable();
    return this.http.patch(`${config.server.url}/group_contacts`, {
      groupContactId: id,
      groupContactName: name
    }).pipe(
      tap((res) => {
        this.menuLoadingService.clear(); console.log(res);
        this.alertRightService.sendNotify(new Alert(AlertType.Success, 'Save success ...'));
      }),
      catchError((err) => {
        return of({});
      })
    );
  }
  public addContactEmail(data: any): Observable<any> {
    console.log(data);
    this.menuLoadingService.setEnable();
    return this.http.post(`${config.server.url}/group_contact_contents`, data).pipe(
      tap((res) => {
        this.menuLoadingService.clear(); console.log(res);
        this.alertRightService.sendNotify(new Alert(AlertType.Success, 'Add success ...'));
      }),
      catchError((err) => {
        return of({});
      })
    );
  }
  public convertCard(res: any): any {
    const result: any = [];
    result.to = [];
    result.cc = [];
    const listContact = res.contactContents;
    for (let i = 0; i < listContact.length; i++) {
      if (listContact[i].contactAction === 1) {
        result.to.push(listContact[i]);
      }
      if (listContact[i].contactAction === 2) {
        result.cc.push(listContact[i]);
      }
    }
    return result;
  }
}
