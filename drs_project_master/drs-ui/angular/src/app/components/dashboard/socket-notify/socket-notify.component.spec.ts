import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SocketNotifyComponent } from './socket-notify.component';

describe('SocketNotifyComponent', () => {
  let component: SocketNotifyComponent;
  let fixture: ComponentFixture<SocketNotifyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SocketNotifyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SocketNotifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
