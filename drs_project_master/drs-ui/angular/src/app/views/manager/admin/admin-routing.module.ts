import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ManagerRoleComponent } from './manager-role/manager-role.component';
import { PermissionComponent } from './permission/index';

const routes: Routes = [ {
        path: 'manager-role' , component: ManagerRoleComponent,
    }, {
      path: 'manager-permission', component: PermissionComponent
    }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
