import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { CustomTaskRestService } from '../../../../../_services/custom-task-rest/custom-task-rest.service';
import { PagerServiceService } from '../../../../../_services/manager/pagerservice/pager-service.service';

@Component({
  selector: 'app-custom-task',
  templateUrl: './custom-task.component.html',
  styleUrls: ['../../issues-projects.component.css']
})
export class CustomTaskComponent implements OnInit {
  pagedItems: any[] = [] ;
  isLoading = false; // loading button page
  pager: any = {};
  itemEdit: any ;
  @Output()
  customCardSelect: EventEmitter<any> = new EventEmitter<any>();
  @Output()
  editCustomTask: EventEmitter<any> = new EventEmitter<any>();
  constructor( private customTaskRestService: CustomTaskRestService,
    private pagerServiceService: PagerServiceService) {
    this.setPage(1);
   }

  ngOnInit() {
  }
  public toStringDate(date): string {
    const ng: number = date;
    const temp = new Date(ng);
    return `${temp.getMonth() + 1}/${temp.getDate()}/${temp.getFullYear()}`;
  }
  setPage(page: number) {
    this.isLoading = true;
    const size = 1;
    if (page < 1 || page > this.pager.totalPages) {
      return;
    }
    // get pager object from servic
    this.customTaskRestService.getCustomTasks(page, size).subscribe( (res: any ) => {
       if (res.listOfReports.length !== 0 ) {
        this.pagedItems = res.listOfReports;
        this.pager = this.pagerServiceService.getPager(res.totalRecords, page, size);
       }
      this.isLoading = false ;
    }, (err: HttpErrorResponse) => {    this.isLoading = false ; });
  }
  addItemToday(item) {
    this.pagedItems.forEach((ite, index) => {
      if (ite.custom_task_id === item.custom_task_id) {
        this.pagedItems[index].isToday  = 2;
      }
    });
    this.customCardSelect.emit({status: 1 , data: item  } );
  }
  addItemToMorrow(item) {
    this.pagedItems.forEach((ite, index) => {
      if (ite.custom_task_id === item.custom_task_id) {
        this.pagedItems[index].isTomorrow  = 3;
      }
    });
    this.customCardSelect.emit({status: 2 , data: item  } );
  }
  public editItemCustomTask(item) {
      console.log('edit');
      this.itemEdit = item ;
    this.editCustomTask.emit(item);
  }
  public setItemEdit(item: any ) {
    this.itemEdit = item ;
    const dataCopy = [...this.pagedItems] ;
    // dataCopy.forEach( (res: any, index ) => {
    //     if ( res.custom_task_id === item.ustom_task_id ) {
    //      dataCopy[index]  = item ;
    //     }
    // } ) ;
    this.setPage(this.pager.currentPage);
  }
}
