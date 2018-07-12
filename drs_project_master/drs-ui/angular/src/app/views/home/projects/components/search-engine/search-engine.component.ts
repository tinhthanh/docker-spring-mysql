import { Component, OnInit, Input  } from '@angular/core';
import { Output, EventEmitter } from '@angular/core';
import { } from '@angular/core/src/metadata/directives';

@Component({
  selector: 'app-search-engine',
  templateUrl: './search-engine.component.html',
  styleUrls: ['./search-engine.component.css']
})
export class SearchEngineComponent implements OnInit {
    searchNameValue: string ;
    @Input()  get searchName() {
      return this.searchNameValue ;
    }
    @Output() searchNameChange = new EventEmitter();
    @Output() search: EventEmitter<any> = new EventEmitter();
    set searchName(val) {
      this.searchNameValue = val;
      this.searchNameChange.emit(this.searchNameValue);
    }
  constructor() { }
  ngOnInit() {
  }
  handelClick() {
    this.searchName = this.searchNameValue;
  }
}
