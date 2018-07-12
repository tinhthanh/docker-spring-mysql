import { EditCardComponent } from './components/edit-card/edit-card.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CardListComponent } from './card-list.component';
import { MyCardComponent } from './components/index';

const routes: Routes = [{
          path: '' , component : CardListComponent,
          children: [
               {
                 path: 'my-card', component: MyCardComponent
               },
               {
                 path: 'edit-card', component: EditCardComponent
               }
          ]
          }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CardListRoutingModule { }
