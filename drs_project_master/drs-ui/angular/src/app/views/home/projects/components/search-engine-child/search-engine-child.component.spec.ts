import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchEngineChildComponent } from './search-engine-child.component';

describe('SearchEngineChildComponent', () => {
  let component: SearchEngineChildComponent;
  let fixture: ComponentFixture<SearchEngineChildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchEngineChildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchEngineChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
