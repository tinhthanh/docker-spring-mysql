import { Component, OnInit, Input } from '@angular/core';
import { NotifyCenter } from '../../../_models/notify/notify-center';

@Component({
  selector: 'app-console-bug',
  templateUrl: './console-bug.component.html',
  styleUrls: ['./console-bug.component.css']
})
export class ConsoleBugComponent implements OnInit {
@Input() notifyCenter: NotifyCenter;
  constructor() { }

  ngOnInit() {
  }

}
