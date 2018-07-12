import { PagesLayoutComponent } from './containers/pages-layout/pages-layout.component';
import { Page404Component } from './views/pages/page-404/page-404.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardLayoutComponent, ManagerLayoutComponent } from './containers/index';


const routes: Routes = [{
      path: '',
      redirectTo: 'dashboard/issues-projects',
      pathMatch: 'full'
        },
        {
        path: '', component: DashboardLayoutComponent,
        loadChildren: './views/home/home.module#HomeModule'
        },
        {
          path: 'pages' , component: PagesLayoutComponent,
          loadChildren: './views/pages/pages.module#PagesModule'
        },
        {
          path: 'manager' , component: ManagerLayoutComponent,
          loadChildren: './views/manager/manager.module#ManagerModule'
        }
        ,
         {
          path: '**',
          component: Page404Component
        }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
