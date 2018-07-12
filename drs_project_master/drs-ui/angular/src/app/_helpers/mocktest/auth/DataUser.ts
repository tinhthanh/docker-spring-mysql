
import { filter } from 'rxjs/operator/filter';
import { Injectable } from '@angular/core';
@Injectable()
export class DataUser {
    public users: any[]  = [];
    constructor() {
        const user1: any = {};
         user1.email = 'tyler.intern@pal.net.vn';
         user1.password = '12345678@N';
         user1.userName = 'Tyler Truong';
        const role1: any[] = [{roleID: 1 , roleName: 'ROLE_ADMIN'} , {roleID: 2,  roleName: 'ROLE_USER'}];
        this.createUser(user1, 'https://www.w3schools.com/howto/img_avatar2.png', role1 );

        const user2: any = {};
        user2.email = 'alex.intern@pal.net.vn';
        user2.password = '12345678@N';
        user2.userName = 'Alex Huynh';
        const role2: any[] = [{roleID: 1 , roleName: 'ROLE_ADMIN'},  {roleID: 2,  roleName: 'ROLE_USER'}];
       this.createUser(user2 , 'https://drive.google.com/uc?id=0B27mfRY62YKZRDNxWWZHdl9aUjA', role2 );

       const user3: any = {};
       user3.email = 'ginny.intern@pal.net.vn';
       user3.password = '12345678@N';
       user3.userName = 'ginny';
       const role3: any[] = [{roleID: 1 , roleName: 'ROLE_ADMIN'},  {roleID: 2,  roleName: 'ROLE_USER'}];
      this.createUser(user3 , 'https://www.w3schools.com/howto/img_avatar.png' , role3);


      const user4: any = {};
      user4.email = 'dustin.intern@pal.net.vn';
      user4.password = '12345678@N';
      user4.userName = 'dustin';
      const role4: any[] = [ {roleID: 2,  roleName: 'ROLE_USER'}];
     // tslint:disable-next-line:max-line-length
     this.createUser(user4 , 'https://img00.deviantart.net/643d/i/2012/160/c/8/takayuki_kun__chibi_avatar_for_exgrs_remake__by_rozhenhire-d52uj8v.png' , role4);

    }
    public createUser(user: any , avatar?: string , role?: any[]) {
        const temp: any = {};
        temp.email = user.email;
        temp.password = user.password;
        temp.userName = user.userName;
        temp.userID =  'ND' + this.users.length ;
          temp.registrationDate =  {
            dayOfYear: 328,
            month: 'NOVEMBER',
             year: 2017,
             dayOfMonth: 24,
            dayOfWeek: 'FRIDAY',
            hour: 23,
            minute : 53,
            nano: 0,
            second: 35,
            monthValue: 11,
            chronology: {
              id: 'ISO',
              calendarType: 'iso8601'
            }
          };
          temp.avatar =  avatar;
          temp.score = 0 ;
          temp.status = 1;
          temp.address = 'HCM';
          temp.phoneNumber = '01642222992';
          temp.permission  =  role;



          temp.lastPasswordResetDate =  {
              dayOfYear: 328,
              month: 'NOVEMBER',
               year: 2017,
               dayOfMonth: 24,
              dayOfWeek: 'FRIDAY',
              hour: 23,
              minute : 53,
              nano: 0,
              second: 35,
              monthValue: 11,
              chronology: {
                id: 'ISO',
                calendarType: 'iso8601'
              }
            };
            this.users.push(temp);
    }
    public save(): void {
      localStorage.setItem('DATAUSER', JSON.stringify(this.users));
    }
    public load(): void  {
      const localdata = JSON.parse(localStorage.getItem('DATAUSER'));
       if ( !localdata ) {
         this.save();
       } else {
         this.users = localdata ;
       }
    }
    public checkToken(email): boolean {
      const filteredUsers = this.users.filter((user: any) => {
        return user.email === email;
    });
    if ( filteredUsers.length ) {
      return true;
    } else {
      return false;
    }
    }
}
