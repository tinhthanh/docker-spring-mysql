import { AdapterTask } from './../../../../../_models/AdapterTask';
import { cacheStorage } from './../../../../../_cache/cacheStorage';
import { UserInfo } from './../../../../../_models/user/user-info';
import { GroupContactService } from './../../../../../_services/group-contact/group-contact.service';
import { SendIssuesService } from './../../../../../_services/manager/issues/send-issues.service';
// import { ShareIssuesService } from './../../../../../_services/manager/shared/share-issues.service';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Input } from '@angular/core';
import { config } from '../../../../../_models/config';
import { UserService } from '../../../../../_services/manager/user/user.service';

@Component({
  selector: 'app-send-report',
  templateUrl: './send-report.component.html',
  styleUrls: ['./send-report.component.css']
})
export class SendReportComponent implements OnInit {
  dateNow = new Date();
  month = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
  from  = 'Report from : Alex.intern@pal.net.vn';
  subject = '';

  public items: Array<any> = [];
  value: any = ['Athens'];
  emailNew: string;
  valueTo: Array<any> = [];
  valueCC: Array<any> = [];
  htmlSend: string;
  isloading = false;
  @Input() isShowSendReport;
  @Output() callBackEvent: EventEmitter<any> = new EventEmitter<boolean>();
  constructor(
    // private shareIssuesService: ShareIssuesService,
    private sendIssuesService: SendIssuesService,
    private groupContactService: GroupContactService,
    private userService: UserService ) {
      if (  localStorage.getItem(config.client.info) ) {
        const  currentUser: UserInfo = JSON.parse(decodeURIComponent(atob(localStorage.getItem(config.client.info)))) ;
        console.log(currentUser);
        this.from =  `Report from :  ${currentUser.email}`;
        // tslint:disable-next-line:max-line-length
        this.subject = `[Daily Report] ${this.dateNow.getDate()} ${this.month[this.dateNow.getMonth()]} ${this.dateNow.getFullYear()} ${this.from} `;
     }
     this.userService.getAllUser().subscribe( ( res: any ) => {
            console.log(res);
            this.items  = [] ;
            res.forEach(element => {
              this.items.push({ id: element.mail , text: element.mail });
            });
     });
    }
  ngOnInit() {
  }
  public callBackGenericHtml($event) {
    this.htmlSend = $event;
  }
  public addNewMail($event): void {
    const temp: Array<any> = [...this.items];
    temp.push(this.emailNew);
    this.emailNew = null;
    this.items = temp;
  }
  public typed(value: any): void {
    // tslint:disable-next-line:max-line-length
    if (value.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) {
      // There was a match.
      this.emailNew = value;
    } else {
      this.emailNew = null;
    }
  }
  public callBackHide() {
    this.callBackEvent.emit(false);
  }
  public refreshValueTo(value: any): void {
    this.valueTo = value;
  }
  public sendReport() {
    if ( this.valueTo.length !== 0  ) {
      let todays: AdapterTask[] = [] ;
      let tomorrows: AdapterTask[] = [] ;
      if (!localStorage.getItem(cacheStorage.listTask.today)) {
        // save
        localStorage.setItem(cacheStorage.listTask.today, btoa(encodeURIComponent(JSON.stringify([]))));
      } else {
        todays =  JSON.parse(decodeURIComponent(atob(localStorage.getItem(cacheStorage.listTask.today))));
      }
      if (!localStorage.getItem(cacheStorage.listTask.tomorrow)) {
        //  save
        localStorage.setItem(cacheStorage.listTask.tomorrow, btoa(encodeURIComponent(JSON.stringify([]))));
      } else {
        tomorrows =  JSON.parse(decodeURIComponent(atob(localStorage.getItem(cacheStorage.listTask.tomorrow))));
      }
    this.isloading = true ;
    this.htmlSend = this.render() +  this.htmlSend;
    this.sendIssuesService.sendReport(this.valueTo, this.valueCC, this.subject, this.htmlSend, 2
      , todays,
      tomorrows , this.from
    ).subscribe(data => {
      this.isloading = false;
      this.callBackEvent.emit(true);
      console.log(data);
      // this.shareIssuesService.refresh();
    });
  }
  }
  public saveReport() {
    let todays: AdapterTask[] = [] ;
    let tomorrows: AdapterTask[] = [] ;
    if (!localStorage.getItem(cacheStorage.listTask.today)) {
      // save
      localStorage.setItem(cacheStorage.listTask.today, btoa(encodeURIComponent(JSON.stringify([]))));
    } else {
      todays =  JSON.parse(decodeURIComponent(atob(localStorage.getItem(cacheStorage.listTask.today))));
    }
    if (!localStorage.getItem(cacheStorage.listTask.tomorrow)) {
      //  save
      localStorage.setItem(cacheStorage.listTask.tomorrow, btoa(encodeURIComponent(JSON.stringify([]))));
    } else {
      tomorrows =  JSON.parse(decodeURIComponent(atob(localStorage.getItem(cacheStorage.listTask.tomorrow))));
    }
    if ( this.valueTo.length !== 0  ) {
    this.isloading = true;
    this.htmlSend = this.render() +  this.htmlSend;
    this.sendIssuesService.sendReport(this.valueTo, this.valueCC, this.subject, this.htmlSend , 1
      , todays,
      tomorrows,
      this.from
    ).subscribe(data => {
      this.isloading = false ;
      console.log(data);
      this.callBackEvent.emit(true);
      // this.shareIssuesService.refresh();
    });
  }
  }
  public refreshValueCC(value: any): void {
    this.valueCC = value;
  }
  public itemsToString(value: Array<any> = []): string {
    return value
      .map((item: any) => {
        return item.text;
      }).join(',');
  }
  public render(): string {
    return `<div style=" margin: 0 0 5px 5px; ">${this.from} </div>`;
  }
  public changeCard($event) {
    this.valueTo = [];
    this.valueCC = [];
      this.groupContactService.getGroupContactsById($event).subscribe( (res) => {
       if (res.to) {
        const valueToTemp = [];
        const valueCCTemp = [];
        res.to.forEach( to => {
          valueToTemp.push({id: to.contactEmail , text: to.contactEmail  });
        });
        res.cc.forEach( cc => {
         valueCCTemp.push({id: cc.contactEmail , text: cc.contactEmail  });
       }
       );
        this.valueTo = valueToTemp ;
        this.valueCC = valueCCTemp;
        console.log(this.valueTo);
        console.log(res.cc);
       }
    });
  }
}

