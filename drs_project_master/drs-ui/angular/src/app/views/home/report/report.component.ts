import { cacheStorage } from './../../../_cache/cacheStorage';
import { AdapterTask } from './../../../_models/AdapterTask';
import { AfterViewInit, Input, EventEmitter } from '@angular/core';
import { Component, OnInit, ViewChild, ElementRef, Output } from '@angular/core';
// import { ShareIssuesService } from '../../../_services/manager/shared/share-issues.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit, AfterViewInit {
  today: AdapterTask[] = [] ;
  tomorrow: AdapterTask[] = [];
  @Input() isShow = true;
  @Output() callBackGenericHtml: EventEmitter<any> = new EventEmitter<any>();
  @ViewChild('report') el: ElementRef;
  constructor(
    // private shareIssuesService: ShareIssuesService
  ) {
    if (!localStorage.getItem(cacheStorage.listTask.today)) {
      // save
      localStorage.setItem(cacheStorage.listTask.today, btoa(encodeURIComponent(JSON.stringify([]))));
    } else {
      const today: AdapterTask[] =  JSON.parse(decodeURIComponent(atob(localStorage.getItem(cacheStorage.listTask.today))));
     this.today = today;
    }
    if (!localStorage.getItem(cacheStorage.listTask.tomorrow)) {
      //  save
      localStorage.setItem(cacheStorage.listTask.tomorrow, btoa(encodeURIComponent(JSON.stringify([]))));
    } else {
     const tomorrow: AdapterTask[] =  JSON.parse(decodeURIComponent(atob(localStorage.getItem(cacheStorage.listTask.tomorrow))));
     this.tomorrow = tomorrow;
  }
  }
  ngOnInit() {
  }
  ngAfterViewInit() {
    this.callBackGenericHtml.emit(this.el.nativeElement.innerHTML);
}
  public toStringDate( date ): string {
    const temp = new Date(date);
    return  `${temp.getDate()  }/${temp.getMonth() + 1 }/${temp.getFullYear()}` ;
  }

}
