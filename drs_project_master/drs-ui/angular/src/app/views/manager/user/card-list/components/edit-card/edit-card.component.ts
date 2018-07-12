import { HttpErrorResponse } from '@angular/common/http';
import { GroupContactService } from './../../../../../../_services/group-contact/group-contact.service';
import { Component, OnInit, Input } from '@angular/core';
import { EventEmitter, Output } from '@angular/core';
@Component({
  selector: 'app-edit-card',
  templateUrl: './edit-card.component.html',
  styleUrls: ['./edit-card.component.css']
})
export class EditCardComponent implements OnInit {
  @Output() back: EventEmitter<any> = new EventEmitter<any>();
  @Input() id: number;
  @Output() updateName: EventEmitter<any> = new EventEmitter<any>();
  @Output() updateAdd: EventEmitter<any> = new EventEmitter<any>();
  @Input() changeOrAdd: boolean;
  groupEdit: any;
  isLoading = false;
  isMatchEmail = false;
  emailValue = '';
  constructor(private groupContactService: GroupContactService) {
  }

  ngOnInit() {
    if (this.id === -1) {
      this.groupEdit = { groupContactId: this.id, groupContactName: '', contactContents: [] };
    } else {
      this.groupContactService.getGroup(this.id).subscribe((res: any) => {
        this.groupEdit = res;
        console.log(this.groupEdit);
      });
    }
  }
  public backCardList() {
    this.back.emit({ back: false });
  }
  public deleteContact(item: any) {
    this.groupContactService.deleteContact(item.id).subscribe((res => {
      item.status = 2;
      console.log(res);
    }));
  }

  public addContactTo() {
    if (this.isMatchEmail) {
      const contact = {
        contactAction: 1,
        contactEmail: this.emailValue,
        groupContactId: this.groupEdit.groupContactId
      };
      this.groupContactService.addContactEmail(contact).subscribe((res: any) => {
        this.emailValue = '';
        this.isMatchEmail = false;
        this.groupEdit.contactContents.push(res);
      });

    }
  }
  public addContactCC() {
    if (this.isMatchEmail) {
      const contact = {
        contactAction: 2,
        contactEmail: this.emailValue,
        groupContactId: this.groupEdit.groupContactId
      };
      this.groupContactService.addContactEmail(contact).subscribe((res: any) => {
        this.emailValue = '';
        this.isMatchEmail = false;
        this.groupEdit.contactContents.push(res);
      });

    }
  }
  public chageEmail($event) {
    // tslint:disable-next-line:max-line-length
    if ($event.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) {
      this.isMatchEmail = true;
    } else {
      this.isMatchEmail = false;
    }
  }
  public changeNameGruop(id: number) {
    this.isLoading = true;
    if (id === -1) {
      this.groupContactService.addGroupContact(this.groupEdit.groupContactName).subscribe((res: any) => {
        this.updateAdd.emit(res);
        this.changeOrAdd = true;
        this.groupEdit = res;
        this.isLoading = false;
      }, (err: HttpErrorResponse) => this.isLoading = false);
    } else {
      this.groupContactService.editContact(id, this.groupEdit.groupContactName).subscribe(res => {
        this.updateName.emit(res);
        this.isLoading = false;
      }, (err: HttpErrorResponse) => this.isLoading = false);
    }
  }
}
