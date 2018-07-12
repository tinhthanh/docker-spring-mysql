import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PagesLayoutComponent } from './pages-layout.component';

describe('PagesLayoutComponent', () => {
  let component: PagesLayoutComponent;
  let fixture: ComponentFixture<PagesLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PagesLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PagesLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
