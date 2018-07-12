import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewReportSaveComponent } from './view-report-save.component';

describe('ViewReportSaveComponent', () => {
  let component: ViewReportSaveComponent;
  let fixture: ComponentFixture<ViewReportSaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewReportSaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewReportSaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
