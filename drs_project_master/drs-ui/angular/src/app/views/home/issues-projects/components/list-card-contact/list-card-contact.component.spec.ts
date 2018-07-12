import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCardContactComponent } from './list-card-contact.component';

describe('ListCardContactComponent', () => {
  let component: ListCardContactComponent;
  let fixture: ComponentFixture<ListCardContactComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListCardContactComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCardContactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
