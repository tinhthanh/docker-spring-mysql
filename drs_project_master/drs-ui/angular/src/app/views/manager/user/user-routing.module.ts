import { ViewReportSaveComponent } from './view-report-save/view-report-save.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user.component';
import { ViewReportSendComponent } from './view-report-send/view-report-send.component';
import { EditSaveReportService } from '../../../_services/manager/user/edit-save-report.service';

const routes: Routes = [ {
     path: '' , component: UserComponent,
    children: [
      {
        path: 'view-report-send' , component: ViewReportSendComponent
      },
      {
        path: 'view-report-save' , component: ViewReportSaveComponent
      },
      {
        path: 'card-list', loadChildren: './card-list/card-list.module#CardListModule'
      }
    ]
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [EditSaveReportService]
})
export class UserRoutingModule { }
