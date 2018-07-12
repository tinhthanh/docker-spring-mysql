import { Report } from './Report';
import { Recipients } from './Recipients';
export class FormSaveReport {
    reportSubject: string;
    reportType: number ;
    dataEtc: string ;
    tasks: Report[] ;
    recipients: Recipients[] ;
    rawTaskInfo: string ;
 }
