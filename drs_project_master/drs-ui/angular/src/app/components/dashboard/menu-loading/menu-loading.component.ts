import { Component, OnInit } from '@angular/core';
import { MenuLoadingService } from '../../../_services/notify/menu/menu-loading.service';
import $ from 'jquery';

@Component({
  selector: 'app-menu-loading',
  templateUrl: './menu-loading.component.html',
  styleUrls: ['./menu-loading.component.css']
})
export class MenuLoadingComponent implements OnInit {
 isLoadingMenu = false ;
 private stompClient;

  constructor(private menuLoadingService: MenuLoadingService ) {
    this.menuLoadingService.notify().subscribe( (res: boolean ) =>  {
      this.isLoadingMenu = res;
    });
    // chatService.messages.subscribe(msg => {
    //   console.log('Response from websocket: ' + msg);
    //   });
    this.initializeWebSocketConnection();
   }
   private message = {
    author: 'tutorialedge',
    message: 'this is a test message'
  };



   initializeWebSocketConnection() {
    // const ws = new SockJS('http://localhost:8080/drs-web-service/chat');
    //  const ws = new WebSocket('http://localhost:8080/drs-web-service/chat');
    // this.stompClient = Stomp.over(ws);
   }


  //  initializeWebSocketConnection() {
  //   const ws = new SockJS('http://localhost:8080/drs-web-service/socket');
  //   this.stompClient = Stomp.over(ws);
  //   const that = this;
  //   this.stompClient.connect({}, function(frame) {
  //     that.stompClient.subscribe('/chat', (message) => {
  //       if (message.body) {
  //         $('.chat').append('<div class="message">' +  message.body + '</div>');
  //         console.log(message.body);
  //       }
  //     });
  //   });
  // }

  sendMessage(message) {
    this.stompClient.send('/app/send/message' , {}, message);
    $('#input').val('');
  }
  ngOnInit() {
//  setTimeout( () => {
// this.notifyM();
//  } , 5000);
  }
  // public notifyM() {
  //  this.menuLoadingService.setEnable() ;
  //  setTimeout( () => {
  //   this.menuLoadingService.clear();
  //  }, 5000 );
  // }

}
