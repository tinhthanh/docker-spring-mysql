import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchByUserComponent } from './search-by-user.component';

describe('SearchByUserComponent', () => {
  let component: SearchByUserComponent;
  let fixture: ComponentFixture<SearchByUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchByUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchByUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
