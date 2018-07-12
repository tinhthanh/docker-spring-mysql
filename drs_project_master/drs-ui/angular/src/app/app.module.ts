import { ListenChangeRedmineService } from './_services/manager/user/listen-change-redmine.service';
import { RequestCacheService } from './_cache/requestCache.service';
import { AuthService } from './_services/manager/user/auth.service';
import { AuthGuardAdmin } from './_guards/AuthGuardAdmin';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './_services/manager/user/user.service';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { Page404Component } from './views/pages/page-404/page-404.component';
import { DashboardLayoutComponent, PagesLayoutComponent, ManagerLayoutComponent } from './containers';
import { HomeHeaderComponent,
        HomeFooterComponent ,
        NotifyCenterComponent ,
        ConsoleBugComponent,
        MenuLoadingComponent,
        AlertRightComponent,
        SocketNotifyComponent} from './components';
import { NotifyLoginService } from './_services/manager/user/notify-login.service';
import { JwtFilter } from './_helpers/JwtInterceptor';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import {  FakeTimeResponse } from './_helpers/DelayResponseInterceptor';
import { HttpErrorFilter } from './_helpers/HttpErrorInterceptor';
import { NotifyCenterService } from './_services/notify/center/notify-center.service';
import { MenuLoadingService } from './_services/notify/menu/menu-loading.service';
import { AlertRightService } from './_services/notify/right/alert-right.service';
import { FormsModule } from '@angular/forms';
// import { ShareIssuesService } from './_services/manager/shared/share-issues.service';
import { CacheConfig } from './_cache/cache.interceptor';
import { ListenChangeRedmineRes } from './_helpers/mocktest/redmine/ListenChangeRedmineRes';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { ListenDataService } from './_services/socket/listen-data.service';

// layout web
const APP_CONTAINERS = [
  DashboardLayoutComponent,
  PagesLayoutComponent,
  ManagerLayoutComponent
];
// component container in layout web
const APP_COMPOMENTS = [
  HomeHeaderComponent,
  HomeFooterComponent,
  NotifyCenterComponent,
  ConsoleBugComponent,
  MenuLoadingComponent,
  AlertRightComponent,
  SocketNotifyComponent];
@NgModule({
  declarations: [
    AppComponent,
    ...APP_CONTAINERS ,
    ...APP_COMPOMENTS,
    Page404Component,
      ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule.forRoot(),
    HttpClientModule,
    FormsModule
  ],
  providers: [
    { provide: LocationStrategy, useClass: HashLocationStrategy },
    UserService,
    NotifyLoginService, // notify user login
    NotifyCenterService, // notify center page,
    AlertRightService,
    MenuLoadingService,
    JwtFilter,
    CacheConfig,
    FakeTimeResponse,
    AuthGuardAdmin,
    AuthService,
    // ShareIssuesService,
    RequestCacheService,
    ListenChangeRedmineService,
    ListenChangeRedmineRes,
    ListenDataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
