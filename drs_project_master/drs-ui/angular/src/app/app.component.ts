import { SpringSocketService } from './_services/socket/spring-socket.service';
import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ SpringSocketService ]
})
export class AppComponent {
  title = 'app';
  constructor(private springSocketService: SpringSocketService) {
  }
}
