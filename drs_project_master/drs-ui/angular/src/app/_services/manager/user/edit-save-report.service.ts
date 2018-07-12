import { Injectable } from '@angular/core';
import { config } from './../../../_models/config';
import { HttpClient } from '@angular/common/http';
import { tap, catchError } from 'rxjs/operators';
import { Observable } from 'rxjs/Observable';
import { Task } from '../../../_models/Task';
@Injectable()
export class EditSaveReportService {
    constructor(private http: HttpClient) {

    }
    public saveReportItem(item): Observable<any> {
        const url = `${config.server.url}/tasks`;
        return this.http.put(url, {
            description: item.description,
            remark: item.remark,
            targetDate:  item.targetDate,
            taskID: item.taskId,
            taskName: item.taskName,
            taskStatus: item.status
        });
    }
}
