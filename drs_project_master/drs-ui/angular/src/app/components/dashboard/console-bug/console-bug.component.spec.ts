import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsoleBugComponent } from './console-bug.component';

describe('ConsoleBugComponent', () => {
  let component: ConsoleBugComponent;
  let fixture: ComponentFixture<ConsoleBugComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsoleBugComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsoleBugComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
