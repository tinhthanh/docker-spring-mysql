import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NotifyCenterComponent } from './notify-center.component';

describe('NotifyCenterComponent', () => {
  let component: NotifyCenterComponent;
  let fixture: ComponentFixture<NotifyCenterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NotifyCenterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotifyCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
