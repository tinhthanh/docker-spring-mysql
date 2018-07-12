import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MailServerComponent } from './mail-server.component';

describe('MailServerComponent', () => {
  let component: MailServerComponent;
  let fixture: ComponentFixture<MailServerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MailServerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MailServerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
