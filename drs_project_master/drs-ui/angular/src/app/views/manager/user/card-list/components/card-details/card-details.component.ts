import { GroupContactService } from './../../../../../../_services/group-contact/group-contact.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit {
   @Input() contactId: any ;
   to: any ;
   cc: any ;
   isLoading  = false ;

  constructor(private groupContactService: GroupContactService) {
  }

  ngOnInit() {
      this.initData();
  }
  public initData() {
    this.isLoading = true ;
    this.groupContactService.getGroupContactsById(this.contactId).subscribe( (res) => {
       this.to  = res.to  ;
       this.cc =  res.cc ;
      console.log();
      this.isLoading = false;
   });
  }

}
