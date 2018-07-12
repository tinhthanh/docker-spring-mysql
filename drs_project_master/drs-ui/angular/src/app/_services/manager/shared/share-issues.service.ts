// import { ListenChangeRedmineService } from './../user/listen-change-redmine.service';
// import { SpringSocketService } from './../../socket/spring-socket.service';
// import { Observable } from 'rxjs/observable';
// import { Task } from './../../../_models/Task';
// import { AdapterTask } from './../../../_models/AdapterTask';
// import { Injectable } from '@angular/core';
// import { config } from '../../../_models/config';
// import { Subject } from 'rxjs/Subject';

// @Injectable()
// export class ShareIssuesService {
//   itemSelectToDay: AdapterTask[] = [];
//   itemSelectTomorrow: AdapterTask[] = [];
//   private subject = new Subject<boolean>();
//   private contFork = new Subject<number>();
//   constructor(private springSocketService: SpringSocketService,
//     private listenChangeRedmineService: ListenChangeRedmineService) {
//     this.springSocketService.getAllMessenger().subscribe( (res: any ) => {
//       const dataCopy = [...this.itemSelectToDay];
//        if ( res.recipient === this.springSocketService.whoami ) {
//          this.listenChangeRedmineService.updateChange().subscribe( (r: any ) => {
//            console.log(r);
//          r.forEach(it => {
//           const task = new Task();
//           task.type = 4 ;
//           task.taskID = it.id ;
//           task.description = it.description ;
//           task.targetDate = new Date() ;
//           task.remark = '' ;
//           task.status = 100;
//           task.taskName =  it.subject ;
//           dataCopy.push( { data : { id : task.taskID } , task : task });
//          });
//       });
//        }
//     this.itemSelectToDay = dataCopy;
//     }
//   );
//   this.loadingData();
//      this.getSub().subscribe(( res: boolean ) => {
//         if ( res) {
//           this.loadingData();
//         }
//      });
//   }
//   public getContFork(): Observable<number>  {
//       return this.contFork.asObservable();
//   }
//   public setCountFork(count: number) {
//     this.contFork.next();
//     this.contFork.next(count);
//   }
//   public loadingData() {
//     this.itemSelectToDay = [];
//     this.itemSelectTomorrow = [];
//     if (!localStorage.getItem(config.client.listTaskFork)) {
//       localStorage.setItem(config.client.listTaskFork, JSON.stringify([]));
//     }
//     const listOfTaskForks: any[] = JSON.parse(localStorage.getItem(config.client.listTaskFork));
//     console.log(listOfTaskForks);
//     this.setCountFork(listOfTaskForks.length);
//     for ( let i = 0; i <  listOfTaskForks.length ; i++ ) {
//        if ( listOfTaskForks[i].taskDateDefined ===  2) {
//         const task = new Task();
//         task.description = listOfTaskForks[i].description;
//         task.remark = listOfTaskForks[i].remark;
//         task.status = listOfTaskForks[i].status;
//         // tslint:disable-next-line:max-line-length
//         task.targetDate =  new Date(listOfTaskForks[i].target_date.year , listOfTaskForks[i].target_date.monthValue - 1 , listOfTaskForks[i].target_date.dayOfMonth);
//         task.taskName = listOfTaskForks[i].taskName ;
//         const temp = { data: {id: 1000000 +  listOfTaskForks[i].taskId  }, task: task };
//         this.itemSelectTomorrow.push(temp);
//        } else if ( listOfTaskForks[i].taskDateDefined ===  1) {
//         const task = new Task();
//         task.description = listOfTaskForks[i].description;
//         task.remark = listOfTaskForks[i].remark;
//         task.status = listOfTaskForks[i].status;
//         task.taskID = listOfTaskForks[i].taskId;
//         // tslint:disable-next-line:max-line-length
//         task.targetDate =  new Date(listOfTaskForks[i].target_date.year , listOfTaskForks[i].target_date.monthValue - 1 , listOfTaskForks[i].target_date.dayOfMonth);
//         task.taskName = listOfTaskForks[i].taskName ;
//         const temp = { data: {id: 1000000 +  listOfTaskForks[i].taskId }, task: task };
//         this.itemSelectToDay.push(temp);
//        }
//      }
//   }
//   sendChage(notify: boolean) {
//       this.subject.next(notify);
//   }
//   clear() {
//       this.subject.next();
//   }
//   getSub(): Observable<boolean> {
//       return this.subject.asObservable();
//   }
//   public refresh() {
//     while (this.itemSelectToDay.length !== 0) {
//       this.itemSelectToDay.pop();
//     }
//     while (this.itemSelectTomorrow.length !== 0) {
//       this.itemSelectTomorrow.pop();
//     }
//   }

// }
