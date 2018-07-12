import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewReportSendComponent } from './view-report-send.component';

describe('ViewReportSendComponent', () => {
  let component: ViewReportSendComponent;
  let fixture: ComponentFixture<ViewReportSendComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewReportSendComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewReportSendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
