import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlertRightComponent } from './alert-right.component';

describe('AlertRightComponent', () => {
  let component: AlertRightComponent;
  let fixture: ComponentFixture<AlertRightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlertRightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlertRightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
