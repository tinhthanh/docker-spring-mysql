import { UserInfo } from './../_models/user/user-info';
import { NotifyCenterService } from './../_services/notify/center/notify-center.service';
import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { config } from '../_models/config';
import { Role } from '../_models/user/role';

@Injectable()
export class AuthGuardAdmin implements CanActivate {
     isContinue = false;
    constructor(private router: Router, private  notifyCenterService: NotifyCenterService ) { }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (localStorage.getItem(config.client.userToken)) {
            if (  localStorage.getItem(config.client.info) ) {
                  const  currentUser: UserInfo = JSON.parse(decodeURIComponent(atob(localStorage.getItem(config.client.info)))) ;
                this.isCheck(currentUser.permission);
                 if ( this.isContinue) {
                    return this.isContinue ;
                } else {
                    this.notifyCenterService.sendNotifyCenter({massage: 'Please login with ADMIN...' , status: 403, details: null });
                    return false;
                 }
            } else {
                return false ;
            }
        } else {
            this.notifyCenterService.sendNotifyCenter({massage: 'Please login with ADMIN...' , status: 403, details: null });
            this.router.navigate(['/dashboard/login'], { queryParams: { returnUrl: state.url }});
            return false;
        }
    }
    async  isCheck(permission: any[] ) {
                  await  permission.forEach((res: Role ) => {
                        if ( res.roleName === config.roles.admin ) {
                            this.isContinue = true;
                        }
                 } );
    }
    public setEnable() {
        this.isContinue = false;
    }
}
