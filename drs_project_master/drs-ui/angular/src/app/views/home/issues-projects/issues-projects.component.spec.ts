import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IssuesProjectsComponent } from './issues-projects.component';

describe('IssuesProjectsComponent', () => {
  let component: IssuesProjectsComponent;
  let fixture: ComponentFixture<IssuesProjectsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IssuesProjectsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IssuesProjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
