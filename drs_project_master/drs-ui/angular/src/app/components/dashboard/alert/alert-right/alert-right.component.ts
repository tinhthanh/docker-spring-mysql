import { Alert, AlertType } from './../../../../_models/notify/alert';
import { Component, OnInit } from '@angular/core';
import { AlertRightService } from '../../../../_services/notify/right/alert-right.service';

@Component({
  selector: 'app-alert-right',
  templateUrl: './alert-right.component.html',
  styleUrls: ['./alert-right.component.css']
})
export class AlertRightComponent implements OnInit {
   alert: Alert ;
   isShowCenterMs = false;
  constructor(private alertRightService: AlertRightService) {
    this.alertRightService.getNotify().subscribe( (res: Alert ) => {
      this.isShowCenterMs = true;
        this.alert = res;
       console.log(this.alert);
        setTimeout( () => { this.isShowCenterMs = false; } , 5000);
    });
  }
  ngOnInit() {

    // this.alertRightService.sendNotify(new Alert(AlertType.Success , 'Sucesses'));
    // setTimeout( () => {
    //   this.alertRightService.clearNotify();
    // } , 5000);
  }
}
