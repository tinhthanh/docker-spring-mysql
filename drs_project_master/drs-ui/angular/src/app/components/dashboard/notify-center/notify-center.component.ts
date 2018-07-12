import { NotifyCenter } from './../../../_models/notify/notify-center';
import { Component, OnInit } from '@angular/core';
import { NotifyCenterService } from '../../../_services/notify/center/notify-center.service';

@Component({
  selector: 'app-notify-center',
  templateUrl: './notify-center.component.html',
  styleUrls: ['./notify-center.component.css']
})
export class NotifyCenterComponent implements OnInit {
  isShowCenterMs = false;
  notifyCenter:  NotifyCenter ;
  constructor(private notifyCenterService: NotifyCenterService) {
    this.notifyCenterService.getNotifyCenter().subscribe( (res: NotifyCenter) => {
      this.isShowCenterMs = true ;
        this.notifyCenter = res;
        setTimeout( () => { this.isShowCenterMs = false; } , 5000);
    });
   }

  ngOnInit() {
  }
}
