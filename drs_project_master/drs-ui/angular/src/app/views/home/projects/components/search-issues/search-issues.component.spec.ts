import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchIssuesComponent } from './search-issues.component';

describe('SearchIssuesComponent', () => {
  let component: SearchIssuesComponent;
  let fixture: ComponentFixture<SearchIssuesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchIssuesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchIssuesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
