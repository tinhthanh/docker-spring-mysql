import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuLoadingComponent } from './menu-loading.component';

describe('MenuLoadingComponent', () => {
  let component: MenuLoadingComponent;
  let fixture: ComponentFixture<MenuLoadingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuLoadingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuLoadingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
