import { config } from './../../../../../../_models/config';
import { GroupContactService } from './../../../../../../_services/group-contact/group-contact.service';
import { GruopContact } from './../../../../../../_models/group-contact/GroupContact';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-card',
  templateUrl: './my-card.component.html',
  styleUrls: ['./my-card.component.css']
})
export class MyCardComponent implements OnInit {
  isShowAddCard = false;
  gruopContact: GruopContact[];
  id: number; // id select ;
  cardDefaul: number;
  changeOrAdd = false; // if state change return true (changeState: true, addState: false)
  constructor(private groupContactService: GroupContactService,
    private router: Router) {
    if (!localStorage.getItem(config.client.userToken)) {
      this.router.navigate(['/dashboard/login']);
    }
    this.load();
    if (localStorage.getItem(config.client.cardDefault)) {
      this.cardDefaul = Number(localStorage.getItem(config.client.cardDefault));
    }
  }
  ngOnInit() {
  }
  public load() {
    if (localStorage.getItem(config.client.userToken)) {
    this.groupContactService.getGroupContacts().subscribe( ( res: any  ) => {
      console.log(res);
      this.gruopContact = res.listOfReports;
      console.log(this.gruopContact);
    });
    }
  }
  public editCardBackList($event) {
    console.log($event);
    this.load();
    this.isShowAddCard = $event.back;
  }
  public editGruopContact(id: number) {
    this.changeOrAdd = true;
    this.id = id;
    this.isShowAddCard = true;
  }
  public newGroupCard() {
    this.id = -1;
    this.isShowAddCard = true;
  }
  public addDefaultCard(carId: string) {
    this.cardDefaul = Number(carId);
    localStorage.setItem(config.client.cardDefault, carId);
  }
  public deleteGroup(item: any) {
    this.groupContactService.deleteGroup(item.group_contact_id).subscribe((res: any) => {
      console.log('delete success..');
      item.status = 2;
    });
  }
  public updateName($event) {
    this.gruopContact.every((value, index) => {
      if (value.group_contact_id === $event.groupContactId) {
        value.group_contact_name = $event.groupContactName;
        return false;
      } else {
        return true;
      }
    });
  }
  updateAdd($event) {
    const groupContact = new GruopContact($event.groupContactId, $event.groupContactName);
    this.gruopContact.push(groupContact);
  }
}
