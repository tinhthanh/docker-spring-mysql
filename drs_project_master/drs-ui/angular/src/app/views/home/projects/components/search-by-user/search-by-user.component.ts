import { cacheStorage } from './../../../../../_cache/cacheStorage';
import { ISubscription } from 'rxjs/Subscription';
import { async } from '@angular/core/testing';
import { SelectItem } from 'ng2-select';
import { NotifyLoginService } from './../../../../../_services/manager/user/notify-login.service';
import { UserService } from './../../../../../_services/manager/user/user.service';
import { Component, OnInit, Input, Output, EventEmitter, OnDestroy } from '@angular/core';
import { NgZone } from '@angular/core';
import { UserInfo } from '../../../../../_models/user/user-info';
@Component({
  selector: 'app-search-by-user',
  templateUrl: './search-by-user.component.html',
  styleUrls: ['./search-by-user.component.css']
})
export class SearchByUserComponent implements OnInit, OnDestroy {
  @Output() searchByUser: EventEmitter<SelectItem> = new EventEmitter<SelectItem>();
  public items  = [];
  private user: any ;
  active: any[] = []  ;
  isShow = false;
  private subscription: ISubscription;
  @Input() isShowCustomTask = false ;
  constructor(private userService:  UserService, private notifyLoginService: NotifyLoginService , private zone: NgZone) {
    this.isShow = false;
    this.items = [] ;
    this.items.push({ id: '*' , text: 'All user'});
   }
  ngOnInit() {
    this.zone.run(() => {
      if ( sessionStorage.getItem(cacheStorage.userService.userInfo)  ) {
        const userInfo = JSON.parse(decodeURIComponent(atob(sessionStorage.getItem(cacheStorage.userService.userInfo))));
          if ( userInfo ) {
            this.active.push( { id: userInfo.id , text: '<< Me >>' });
         this.subscription =   this.userService.getAllUser().subscribe( async (listUser: any[]) => {
              await listUser.forEach( item  => {
                  this.items.push({ id: item.id  , text: (item.mail ===  userInfo.email ) ? '<< Me >>' : item.mail });
              });
              this.isShow = true;
            });
          }
      }
    });
  }
  refreshValue($event) {

  }
  selected($event) {
      this.searchByUser.emit($event);
  }
  removed($event) {
  }
  ngOnDestroy(): void {
    if (   this.subscription ) {
      this.subscription.unsubscribe();
    }
  }
}
