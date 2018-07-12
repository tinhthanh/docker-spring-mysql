import { AdapterTask } from './../AdapterTask';
import { Recipients } from './Recipients';
import { FormSaveReport } from './FormSaveReport';
import { Report } from './Report';

export class AdapterReport {
    valueTo: Array<any>;
    valueCC: Array<any>;
    subject: string;
    rawTaskInfo: string;
    reportType: number ;
    itemSelectToDay: AdapterTask[];
    itemSelectTomorrow: AdapterTask[];
    dataEtc: string ;
constructor( valueTo: Array<any>,  valueCC: Array<any> , subject: string, rawTaskInfo: string , reportType: number,
    itemSelectToDay: AdapterTask[],
    itemSelectTomorrow: AdapterTask[],   dataEtc: string  ) {
   this.valueTo = valueTo ;
   this.valueCC = valueCC ;
   this.subject = subject ;
   this.rawTaskInfo = rawTaskInfo ;
   this.reportType = reportType ;
   this.itemSelectToDay = itemSelectToDay;
   this.itemSelectTomorrow  = itemSelectTomorrow ;
   this.dataEtc = dataEtc ;
}
public getFormSaveReport(): FormSaveReport {
    const result = new FormSaveReport() ;
     result.dataEtc = this.dataEtc;
     result.reportSubject = this.subject ;
     result.reportType = this.reportType ;
     result.rawTaskInfo = this.rawTaskInfo;
     const arr: Recipients[] = [];
     const tasks: Report[] = [];
      this.itemSelectToDay.forEach( res => {
            const temp = new Report() ;
            temp.description = res.task.description ;
            temp.remark = res.task.remark ;
            temp.taskName = res.task.taskName ;
            temp.taskStatus = res.task.status ;
            const date: Date = res.task.targetDate ;
            temp.targetDate = date;
            temp.taskDateDefined = 1 ;
            tasks.push(temp);
      });
      this.itemSelectTomorrow.forEach( res => {
        const temp = new Report() ;
        temp.description = res.task.description ;
        temp.remark = res.task.remark ;
        temp.taskName = res.task.taskName ;
        temp.taskStatus = res.task.status ;
        const date: Date = res.task.targetDate ;
        temp.targetDate = date;
        temp.taskDateDefined = 2 ;
        tasks.push(temp);
      });
     result.tasks = tasks;
     this.valueTo.forEach( res => {
         const temp = new Recipients();
         temp.reportRecipientAction = 1;
         temp.reportRecipientEmail = res.text;
            arr.push(temp);
     });
     this.valueCC.forEach( res => {
        const temp = new Recipients();
        temp.reportRecipientAction = 2;
        temp.reportRecipientEmail = res.text;
           arr.push(temp);
    });
        result.recipients = arr;
    return result;
}
}
