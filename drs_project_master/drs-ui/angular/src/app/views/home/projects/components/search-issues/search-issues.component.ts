import { ShareFiltersService } from './../../../../../_services/manager/shared/share-filters.service';
import { SearchEngine } from './../../../../../_models/search-engine/SearchEngine';
import { SelectItem } from 'ng2-select';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
@Component({
  selector: 'app-search-issues',
  templateUrl: './search-issues.component.html',
  styleUrls: ['./search-issues.component.css']
})
export class SearchIssuesComponent implements OnInit {
   @Input() itemsSelect: SelectItem[] = [];
   searchList: SearchEngine[];
   @Output() sendDataSearch: EventEmitter<SearchEngine[]> = new EventEmitter<SearchEngine[]>();
  constructor( private shareFiltersService: ShareFiltersService) {
    this.searchList = this.shareFiltersService.searchList;
  }
  ngOnInit(): void {
  }
  public callBackEventAdd($event): void {
    let flat = false ;
    this.searchList.forEach((item, index) => {
      if (item.root.id === $event.root.id ) {
        if ($event.child === null) {
           this.searchList = this.searchList.splice(index, 0);
        } else {
          this.searchList[index] = $event ;
        }
        flat = true;
      }
    });
    if ( !flat ) {this.searchList.push($event); }
          this.appLy();
  }
  changeSelect($event, data: SelectItem ) {
  if (!$event.target.checked ) {
      data.id += '_';
    } else {
      data.id = data.id.replace('_' , '');
    }
   console.log(this.itemsSelect);
  }
  public unChecked(): void {
    this.itemsSelect.forEach(item => {
     if ( item.id.indexOf('_') === -1 ) {
        item.id = item.id + '_';
    }
    });
    this.searchList.forEach(item => {
      if ( item.root.id.indexOf('_') === -1 ) {
         item.root.id = item.root.id + '_';
     }
     });
  }
  appLy() {
   this.sendDataSearch.emit(this.searchList);
  }
}
