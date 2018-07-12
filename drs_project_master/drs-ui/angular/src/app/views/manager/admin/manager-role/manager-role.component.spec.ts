import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerRoleComponent } from './manager-role.component';

describe('ManagerRoleComponent', () => {
  let component: ManagerRoleComponent;
  let fixture: ComponentFixture<ManagerRoleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerRoleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerRoleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
