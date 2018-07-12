import { ManagerRoleService } from './../../../../_services/admin/manager-role.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manager-role',
  templateUrl: './manager-role.component.html',
  styleUrls: ['./manager-role.component.css']
})
export class ManagerRoleComponent implements OnInit {

  constructor(private managerRole: ManagerRoleService) {
  //   this.managerRole.getAllUserWithRole().subscribe( ( res: any ) => {
  //        console.log(res);
  //   } );
  //   this.managerRole.getStatus(200).subscribe( ( data: any) => {
  //  console.log(data);
  //   });

    this.managerRole.getStatus(400).subscribe( ( data: any) => {
      console.log(data);
       });
   }

  ngOnInit() {
  }

}
