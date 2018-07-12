import { UserService } from './../../../../../_services/manager/user/user.service';
import { SearchEngine } from './../../../../../_models/search-engine/SearchEngine';
import { SelectItem } from 'ng2-select';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ManagerSearch } from '../../../../../_models/search-engine/ManagerSreach';
import { HttpErrorResponse } from '@angular/common/http';
import { UserInfo } from '../../../../../_models/user/user-info';

@Component({
  selector: 'app-search-engine-child',
  templateUrl: './search-engine-child.component.html',
  styleUrls: ['./search-engine-child.component.css']
})
export class SearchEngineChildComponent implements OnInit {
  manager: ManagerSearch = new ManagerSearch() ;
  searchEngine: SearchEngine = new SearchEngine();
  value: any ;
  optionChild: any ;
  optionChildItem =  [] ;
  optionStatus: number;
  @Input() rootItem: SelectItem ;
  @Output() eventAddChildSearch: EventEmitter<SearchEngine> = new EventEmitter<SearchEngine>();
  constructor(private userService: UserService) { }
  ngOnInit() {
    this.searchEngine.root = {id: this.rootItem.id, text: this.rootItem.text};
    this.optionChild  =  this.manager.getChild(this.rootItem.id);
    // console.log(this.optionChild[0].id);
    this.optionChildSelected(this.optionChild[0].id);
  }
  public callBackAddChild() {
    this.eventAddChildSearch.emit(this.searchEngine);
  }
  public optionChildItemSelected(value: any): void {
    this.searchEngine.childrens[0] = ({id: value.id, text: value.text});
    // this.searchEngine.childrens.push({id: value.id, text: value.text}); // mutiple select
    this.callBackAddChild();
  }
  public optionChildItemRemoved(value: any): void {
    this.searchEngine.childrens.forEach( (item, index) => {
      if ( item.id === value.id ) {this.searchEngine.childrens.splice(index, 1); }
    });
  }
  public optionChildItemRefreshValue(value: any): void {
    this.value = value;
  }
  public optionChildSelected(value: any): void {
    this.searchEngine.child = {id: value.id, text: value.text};
    if (this.rootItem.id === 'ID4') {
      this.userService.getUserInfo().subscribe( (data: UserInfo) => {
        console.log(data);
        const user: UserInfo = data;
        this.userService.getAllUser().subscribe( (rs: any[] ) => {
          const result =  this.manager.checkView(this.searchEngine);
        // console.log(this.optionStatus);
        rs.forEach( (res: any , index ) => {
            result.data[index] = {id: res.id , text: (res.mail ===  user.email ) ? '<< Me >>' : res.mail};
        });
                this.optionChildItem =  result.data;
        this.optionStatus = result.status;
        }, ( err: HttpErrorResponse) => {
          console.log(err);
        });
      }, ( err: HttpErrorResponse) => {
        console. log(err);
      });
    } else {
      const result =  this.manager.checkView(this.searchEngine);
      this.optionChildItem =  result.data;
      this.optionStatus = result.status;
    }
  }
  public optionChildRemoved(value: any): void {
    this.searchEngine.child = null;
  }
  public optionChildRefreshValue(value: any): void {
    this.value = value;
  }
  searchChangeText(text: string) {
    this.searchEngine.childrens = [];
    this.searchEngine.childrens.push({id: 'text', text: text});
  }
  changeDate(date: string) {
    this.searchEngine.childrens = [];
    this.searchEngine.childrens.push({id: 'text', text: date});
  }
  changeDateBetweenFist(date: string) {
    this.searchEngine.childrens[0] = {id: 'text', text: date} ;
  }
  changeDateBetweenLast(date: string) {
    this.searchEngine.childrens[1] = {id: 'text', text: date} ;
  }
}
