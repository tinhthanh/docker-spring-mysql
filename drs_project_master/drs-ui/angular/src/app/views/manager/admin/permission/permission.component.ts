import { data } from './../../../../_helpers/mocktest/fake-data/listenFake';
import { Component, OnInit } from '@angular/core';
import { ManagerRoleService } from '../../../../_services/admin/manager-role.service';
import { Observable } from 'rxjs/Observable';
import { UserRoleList, UserSubInfo } from '../../../../_models/user/user-role';
import { Privilege } from '../../../../_models/user/privilege';
import { NgZone } from '@angular/core';
import { UserInfo } from '../../../../_models/user/user-info';
import { BsDatepickerModule } from 'ngx-bootstrap';

const day = ['Sun', 'Mon', 'Tue', 'Wen', 'Thu', 'Fri', 'Sat'];
const month = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];

@Component({
  selector: 'app-permission',
  templateUrl: './permission.component.html',
  styleUrls: ['./permission.component.css']
})
export class PermissionComponent implements OnInit {
  constructor(public roleSv: ManagerRoleService, public zone: NgZone) {
  }
  public userRoleList: Observable<UserSubInfo[]>;
  public privilegeList: Observable<Privilege[]>;
  public listUser: Observable<UserInfo[]>;
  public selectUser: UserSubInfo;
  public updateUser: Privilege;
  public startDate;
  public endDate;
  pageList = new Array<number>();
  selectedPage = 0;
  isValidate = true;
  ngOnInit() {
    this.selectedPage = 0;
    this.updateUser = new Privilege();
    this.updateUser.privilegesStatus = 1;
    this.setSelectPage(0);
  }

  setPage(pageSize) {
    this.pageList = new Array<number>();
    for (let i = 0; i < pageSize; i++) {
      this.pageList.push(i);
    }
  }

  setSelectPage(selectedPage) {
    const pageSize = 5;
    if (selectedPage >= 0 && selectedPage < this.pageList.length) {
      console.log(selectedPage);
      this.selectedPage = selectedPage;
    }
    this.userRoleList = this.roleSv.getAllUserWithRole(this.selectedPage * pageSize, pageSize).map(list => {
      const numPage = Math.floor(list.total / pageSize);
      this.setPage(numPage + (list.total % pageSize > 0 ? 1 : 0));
      return list.listOfUser;
    });

  }

  getUserPrivilege(id) {
    this.userRoleList.map(list => {
      return list.filter(u => u.userId === id.userId)[0];
    }).subscribe(user => {
      this.selectUser = user;
    });
    this.privilegeList = this.roleSv.getAllPrivilegeById(id.userId).map(list => {
      list.forEach(p => {
        p.endDate = new Date(p.endDate);
        p.startDate = new Date(p.startDate);
      });
      return list;
    });

    this.listUser = this.roleSv.getAllUser().map(v => {
      return v.filter(user => user.userName !== id.userName);
    });
    this.privilegeList.subscribe(pri => {
      pri.forEach(p => {
        this.listUser = this.listUser.map(d => {
          return d.filter(u => u.userName !== p.userReportName);
        });
      });
    });
    this.updateUser.userId = id.userId;
  }

  printDate(d: Date) {
    return day[d.getDay()] + ', ' + d.getDate() + '-' + month[d.getMonth()] + '-' + d.getFullYear();
  }
  update() {
    this.isValidate = true;
    if (this.startDate && this.endDate && this.updateUser.userId && this.updateUser.userReportId) {
      this.zone.run(() => {
        this.updateUser.startDate = this.startDate.getTime() ;
        this.updateUser.endDate = this.endDate.getTime();
        if (this.updateUser.startDate < this.updateUser.endDate) {
          console.log(this.updateUser);
          this.roleSv.addPrivilege(this.updateUser).subscribe(dt => {
            this.privilegeList = this.privilegeList.map(pri => {
              dt.startDate = this.updateUser.startDate;
              dt.endDate = this.updateUser.startDate;
              return pri;
            });
            this.listUser = this.listUser.map(d => {
              return d.filter(u => u.userName !== dt.userReportName);
            });
            this.isValidate = true;
          }, err => {
          });
        } else {
          this.isValidate = false;
        }
      });
    }
  }
  delete(id) {
    this.roleSv.deletePrivilege(id).subscribe(isDeleted => {
      if (isDeleted) {
        this.privilegeList = this.privilegeList.map(p => {
          return p.filter(pri => pri.reportPrivilegesId !== id);
        });
      }
    });
  }

}
