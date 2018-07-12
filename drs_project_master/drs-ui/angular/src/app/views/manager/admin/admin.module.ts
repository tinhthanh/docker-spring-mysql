import { HttpClientModule } from '@angular/common/http';
import { ManagerRoleService } from './../../../_services/admin/manager-role.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { ManagerRoleComponent } from './manager-role/manager-role.component';
import { HttpErrorFilter, HttpErrorInterceptor } from '../../../_helpers/HttpErrorInterceptor';
import { JwtFilter } from '../../../_helpers/JwtInterceptor';
import { FakeTimeResponse } from '../../../_helpers/DelayResponseInterceptor';
import { PermissionComponent } from './permission';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { BsDatepickerModule } from 'ngx-bootstrap';

const APP_COMPONENT = [
  PermissionComponent
] ;
@NgModule({
  imports: [
    CommonModule,
    AdminRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    BsDatepickerModule.forRoot()
  ],
  declarations: [AdminComponent, ManagerRoleComponent, PermissionComponent , ...APP_COMPONENT],
  providers: [
    FakeTimeResponse,
    ManagerRoleService,
    JwtFilter,
    HttpErrorFilter
  ]
})
export class AdminModule { }
