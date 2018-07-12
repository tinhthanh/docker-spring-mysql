import { SearchEngine } from './../../../_models/search-engine/SearchEngine';
import { Injectable } from '@angular/core';

@Injectable()
export class ShareFiltersService {
  searchList: SearchEngine[] = [];
  constructor() { }

}
