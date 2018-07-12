import { Task } from './../../../../../../_models/Task';
import { EditSaveReportService } from './../../../../../../_services/manager/user/edit-save-report.service';
import { ReportItem } from './../../../../../../_models/report/ReportItem';
import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

@Component({
  selector: 'app-edit-save-report',
  templateUrl: './edit-save-report.component.html',
  styleUrls: ['./edit-save-report.component.css']
})
export class EditSaveReportComponent implements OnInit {

  constructor(private saveReportService: EditSaveReportService) { }
  public items: Array<any> = [{ id: 'kevin.nguyen@pal.net.vn', text: 'kevin.nguyen@pal.net.vn' },
  { id: 'lee.phan@pal.net.vn', text: 'lee.phan@pal.net.vn' },
  { id: 'dustin.intern@pal.net.vn', text: 'dustin.intern@pal.net.vn' },
  { id: 'harry@pal.net.vn', text: 'harry@pal.net.vn' },
  { id: 'min.intern@pal.net.vn', text: 'min.intern@pal.net.vn' },
  { id: 'ginny.intern@pal.net.vn', text: 'ginny.intern@pal.net.vn' },
  { id: 'nathan.intern@pal.net.vn', text: 'nathan.intern@pal.net.vn' },
  { id: 'alex.intern@pal.net.vn', text: 'alex.intern@pal.net.vn' },
  { id: 'tyler.intern@pal.net.vn', text: 'tyler.intern@pal.net.vn' },
  { id: 'k40cntt@gmail.com', text: 'k40cntt@gmail.com' }];
  targetDate: Date;
  @Output() editState: EventEmitter<boolean> = new EventEmitter<boolean>();
  @Input() reportSaveItem: Task;
  @Output() update: EventEmitter<Task> = new EventEmitter<Task>();
  isloading = false;
  ngOnInit() {
    this.reportSaveItem.targetDate = new Date(this.reportSaveItem.targetDate);
  }

  hideEditReport() {
    this.editState.emit(false);
  }
  saveReport() {
    this.isloading = true;
    this.saveReportService.saveReportItem(this.reportSaveItem).subscribe(data => {
      if (data) {
        this.update.emit(data);
        this.editState.emit(false);
        this.isloading = false;
      }
    });
  }
}
