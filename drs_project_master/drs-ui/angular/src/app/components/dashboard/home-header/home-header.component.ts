
import { Role } from './../../../_models/user/role';
import { Router } from '@angular/router';
import { AuthGuardAdmin } from './../../../_guards/AuthGuardAdmin';
import { config } from './../../../_models/config';
import { HttpErrorResponse } from '@angular/common/http';
import { UserService } from './../../../_services/manager/user/user.service';
import { Component, OnInit, HostListener, OnDestroy } from '@angular/core';
import * as $ from 'jquery';
import { Subscription } from 'rxjs/Subscription';
import { NotifyLoginService } from '../../../_services/manager/user/notify-login.service';
import { UserInfo } from '../../../_models/user/user-info';
import { cacheStorage } from '../../../_cache/cacheStorage';
@Component({
  selector: 'app-home-header',
  templateUrl: './home-header.component.html',
  styleUrls: ['./home-header.component.css']
})
export class HomeHeaderComponent implements OnInit , OnDestroy {
  userInfo: UserInfo;
  subscription: Subscription;
   curr = 0 ;
   isFixedMenu = true;
   isShowNotify = false;
   isShowInfomation = false ;
   countFork =  0 ;
  isAdmin = false;
  //  @HostListener('window:scroll', ['$event'])
  // onWindowScroll() {
  //   const number =
  //     window.pageYOffset ||
  //     document.documentElement.scrollTop ||
  //     document.body.scrollTop ||
  //     0;
  //   if (number > 60) {
  //     this.isFixedMenu = true;
  //   } else {
  //     this.isFixedMenu = false;
  //   }
  // }
  constructor(private notifyService: NotifyLoginService, private userService: UserService,
   private route: Router,
    private authGuardAdmin: AuthGuardAdmin,
   ) {
  //   this.shareIssuesService.getSub().subscribe(( res: boolean ) => {
  //     if ( res) {
  //     }
  //  });
      this.notifyService.getInfo().subscribe( (userInfo: UserInfo ) => {
        this.userInfo = userInfo ;
    });
  }
  ngOnDestroy(): void {
    // unsubscribe to ensure no memory leaks
    // this.subscription.unsubscribe();
  }
  public logout(): void {
    localStorage.removeItem(config.client.userToken);
    localStorage.removeItem(cacheStorage.listTask.today);
    localStorage.removeItem(cacheStorage.listTask.tomorrow);
    localStorage.removeItem(config.client.info);
    this.userInfo = null;
    this.authGuardAdmin.setEnable();
    // this.route.navigate(['/dashboard/login']);
    sessionStorage.clear();
    window.location.reload();
  }
  ngOnInit() {
    if ( localStorage.getItem(config.client.userToken) ) {
     this.userService.getUserInfo().subscribe( (userInfo: UserInfo)  => {
       this.notifyService.sendNotify(userInfo);
         this.userInfo.permission.forEach( r => {
             if ( r.roleName === 'ROLE_ADMIN') {
              this.isAdmin = true;
             }
         });
     }, (err: HttpErrorResponse) => {
       if (err.status === 500 ) {
            console.log('token validate');
       }
       if ( err.status === 0 ) {
         console.log('Server not fault ...');
       }
     });
    }
    $(document).ready( () => {
      $('.mobile_nav').click(function() {

        const mm = $('.mobile_menu'),
            mn = $('.mobile_nav'),
          a = 'active';
        if (mm.hasClass(a) && mn.hasClass(a)) {
          mm.removeClass(a).fadeOut(200);
          mn.removeClass(a);
          $('.mobile_menu li').each(function(){
            $(this).removeClass('slide');
          });
        } else {
          mm.addClass(a).fadeIn(200);
          mn.addClass(a);
          $('.mobile_menu li').each(function(i){
          const t = $(this);
          setTimeout(function(){ t.addClass('slide'); }, (i + 1) * 100);
        });
        }
      });
    }
    );
  }
}
