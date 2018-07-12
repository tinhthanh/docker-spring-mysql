import { FormsModule } from '@angular/forms';
import { GroupContactService } from './../../../../_services/group-contact/group-contact.service';
import { CardListComponent } from './card-list.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TooltipModule } from 'ngx-bootstrap/tooltip';

import { CardListRoutingModule } from './card-list-routing.module';
import { CardDetailsComponent,
         MyCardComponent,
          EditCardComponent } from './components';
const APP_COMPONENTS = [
  CardDetailsComponent,
  MyCardComponent,
  EditCardComponent
];
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    CardListRoutingModule,
    TooltipModule.forRoot()
  ],
  declarations: [ CardListComponent , MyCardComponent , ...APP_COMPONENTS, EditCardComponent],
  providers: [    GroupContactService]
})
export class CardListModule { }
