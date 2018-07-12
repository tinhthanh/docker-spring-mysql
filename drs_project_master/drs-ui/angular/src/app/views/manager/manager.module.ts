import { PagerServiceService } from './../../_services/manager/pagerservice/pager-service.service';
import { ProjectService } from './../../_services/manager/project/project.service';
import { ManagerComponent } from './manager.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ManagerRoutingModule } from './manager-routing.module';
import { MailServerComponent } from './mail-server/mail-server.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { IssuesComponent } from './issues/issues.component';
import { HttpClientModule } from '@angular/common/http';
import { ProjectRes } from '../../_helpers/mocktest';
import { ReportService } from '../../_services/manager/report/report.service';
import { JwtFilter } from '../../_helpers/JwtInterceptor';
import { HttpErrorFilter } from '../../_helpers/HttpErrorInterceptor';
import { FakeTimeResponse } from '../../_helpers/DelayResponseInterceptor';
import { EditSaveReportService } from '../../_services/manager/user/edit-save-report.service';
import { CacheConfig } from '../../_cache/cache.interceptor';


@NgModule({
  imports: [
    CommonModule,
    ManagerRoutingModule,
    HttpClientModule,
  ],
  declarations: [MailServerComponent, ProjectListComponent, ManagerComponent, IssuesComponent],
  providers: [
  FakeTimeResponse,
  JwtFilter,
  HttpErrorFilter,
  ProjectService,
  ProjectRes ,
  ReportService,
  PagerServiceService,
  EditSaveReportService,
  CacheConfig]
})
export class ManagerModule { }
