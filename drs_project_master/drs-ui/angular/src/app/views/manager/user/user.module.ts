import { StringToDate } from './view-report-save/components/edit-save-report/to-date.pipe';
import { EditSaveReportComponent } from './view-report-save/components/edit-save-report/edit-save-report.component';


import { UserComponent } from './user.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { ViewReportSendComponent } from './view-report-send/view-report-send.component';
import { ViewReportSaveComponent } from './view-report-save/view-report-save.component';
import { SelectModule } from 'ng2-select';
import { FormsModule } from '@angular/forms';
import { BsDatepickerModule } from 'ngx-bootstrap';
import { ManagerRoleService } from '../../../_services/admin/manager-role.service';
@NgModule({
  imports: [
    CommonModule,
    UserRoutingModule,
    SelectModule,
    FormsModule,
    BsDatepickerModule.forRoot()
  ],

  declarations: [UserComponent ,
                ViewReportSendComponent,
                ViewReportSaveComponent,
                EditSaveReportComponent,
                StringToDate
          ],
  providers: [
    ManagerRoleService
  ]
})
export class UserModule { }
