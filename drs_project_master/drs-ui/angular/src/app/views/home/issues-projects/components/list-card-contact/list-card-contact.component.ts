import { config } from './../../../../../_models/config';
import { GruopContact } from './../../../../../_models/group-contact/GroupContact';
import { GroupContactService } from './../../../../../_services/group-contact/group-contact.service';
import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-list-card-contact',
  templateUrl: './list-card-contact.component.html',
  styleUrls: ['./list-card-contact.component.css']
})
export class ListCardContactComponent implements OnInit {
  gruopContact:  GruopContact[];
  cardDefault: number ;
  @Output()
  changeCard: EventEmitter<number> = new EventEmitter<number>();

  constructor(private groupContactService: GroupContactService ) {
    this.groupContactService.getGroupContacts().subscribe( ( res: any  ) => {
      console.log(res);
      this.gruopContact =  res.listOfReports ;
      console.log(this.gruopContact);
  });
  }

  public selectcard(id: number) {
    this.cardDefault  = id;
    this.changeCard.emit(id);
  }
   ngOnInit() {
    if ( localStorage.getItem(config.client.cardDefault)) {
      this.cardDefault = Number(localStorage.getItem(config.client.cardDefault));
      this.changeCard.emit(this.cardDefault);
    }
  }

}
