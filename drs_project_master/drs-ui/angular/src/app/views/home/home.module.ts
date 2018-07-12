import { GroupContactService } from './../../_services/group-contact/group-contact.service';
import { SendIssuesService } from './../../_services/manager/issues/send-issues.service';
import { ProjectService } from './../../_services/manager/project/project.service';
import { PagerServiceService } from './../../_services/manager/pagerservice/pager-service.service';
import { HttpClientModule } from '@angular/common/http';
import { IssuesService } from './../../_services/manager/issues/issues.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from '../home/home.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProjectsComponent } from './projects/projects.component';
import { LoginComponent } from './login/login.component';
import { ReportComponent } from './report/report.component';
import { ViewTaskComponent } from './view-task/view-task.component';
import { IssuesProjectsComponent } from './issues-projects/issues-projects.component';
import { NgDragDropModule } from 'ng-drag-drop';
import { TooltipModule } from 'ngx-bootstrap';
import { PopoverModule } from 'ngx-bootstrap/popover';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { RatingModule } from 'ngx-bootstrap/rating';
import { SearchEngineComponent,
         SearchIssuesComponent,
         SearchEngineChildComponent,
         SearchByUserComponent,
         } from './projects/components';
import {NewTaskComponent,
       CustomTaskComponent,
       ListCardContactComponent } from './issues-projects/components';
import {SelectModule} from 'ng2-select';
import { ProjectRes, IssuesRes } from '../../_helpers/mocktest';
import { JwtFilter } from '../../_helpers/JwtInterceptor';
import { AuthenticationRest } from '../../_helpers/mocktest/auth/AuthenticationRest';
import { UserService } from '../../_services/manager/user/user.service';
import { AuthService } from '../../_services/manager/user/auth.service';
import { SendReportComponent } from './issues-projects/components';
import { AlertModule } from 'ngx-bootstrap/alert';
import { ShareFiltersService } from '../../_services/manager/shared/share-filters.service';
import { FakeTimeResponse } from '../../_helpers/DelayResponseInterceptor';
import { HttpErrorFilter } from '../../_helpers/HttpErrorInterceptor';
import { CustomTaskRestService } from '../../_services/custom-task-rest/custom-task-rest.service';
import { CacheConfig } from '../../_cache/cache.interceptor';
const APP_COMPONENTS = [
   SearchEngineComponent,
   SearchIssuesComponent,
   SearchEngineChildComponent,
   SendReportComponent,
   SearchByUserComponent,
   NewTaskComponent,
   CustomTaskComponent,
   ListCardContactComponent
  ];
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HomeRoutingModule,
    SelectModule,
    HttpClientModule,
    NgDragDropModule.forRoot(),
    TooltipModule.forRoot(),
    BsDatepickerModule.forRoot(),
    PopoverModule.forRoot(),
    RatingModule.forRoot(),
    AlertModule.forRoot()
  ],
  declarations: [ DashboardComponent, HomeComponent, ProjectsComponent , IssuesProjectsComponent, LoginComponent,
  ReportComponent , ViewTaskComponent, ...APP_COMPONENTS, SearchIssuesComponent],
  providers: [
    JwtFilter,
    HttpErrorFilter,
    FakeTimeResponse, // fake time response server
    // AuthenticationRest,
    ProjectRes,
    IssuesRes,
    IssuesService,
    PagerServiceService,
    GroupContactService,
    CustomTaskRestService,
    AuthService,
    ProjectService,
    UserService,
    SendIssuesService,
    ShareFiltersService,
    CacheConfig,
]
})
export class HomeModule { }
