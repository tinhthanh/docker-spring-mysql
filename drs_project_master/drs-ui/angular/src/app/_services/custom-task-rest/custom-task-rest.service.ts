import { of } from 'rxjs/observable/of';
import { tap, catchError } from 'rxjs/operators';
import { config } from './../../_models/config';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MenuLoadingService } from './../notify/menu/menu-loading.service';
@Injectable()
export class CustomTaskRestService {

  constructor(private http: HttpClient, private menuLoadingService: MenuLoadingService ) { }
  public getCustomTasks(page: number = 1 , pageSize: number = 10): Observable<any> {
    this.menuLoadingService.setEnable();
    return this.http.get<any>(`${config.server.url}/custom_tasks?page=${page}&pageSize=${pageSize}`).pipe(
      tap((res) => { this.menuLoadingService.clear(); console.log(res); }),
      catchError((err) => {
        return of({});
      })
    );
  }
  public addCustomTask(task: any  ): Observable<any> {
    this.menuLoadingService.setEnable();
    return this.http.post<any>(`${config.server.url}/custom_tasks`,
    {
     description : task.description ,
     name: task.taskName ,
     remark : task.remark ,
     targetDate : task.targetDate ,
     taskStatus: task.status
  }
   ).pipe(
      tap((res) => { this.menuLoadingService.clear(); console.log(res); }),
      catchError((err) => {
        return of({});
      })
    );
  }
  public editCustomTask(task: any  ): Observable<any> {
    this.menuLoadingService.setEnable();
    const targetDate = new Date(task.targetDate);
     targetDate.setHours(12);
    return this.http.put<any>(`${config.server.url}/custom_tasks`,
    {
     customTaskStatus: 0 ,
     description : task.description ,
     id: task.custom_task_id ,
     name: task.taskName ,
     remark : task.remark ,
     targetDate : targetDate ,
     taskStatus: task.status
  }
   ).pipe(
      tap((res) => { this.menuLoadingService.clear(); console.log(res); }),
      catchError((err) => {
        return of({});
      })
    );
  }
}
