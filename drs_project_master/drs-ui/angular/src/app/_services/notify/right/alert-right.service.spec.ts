import { TestBed, inject } from '@angular/core/testing';

import { AlertRightService } from './alert-right.service';

describe('AlertRightService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AlertRightService]
    });
  });

  it('should be created', inject([AlertRightService], (service: AlertRightService) => {
    expect(service).toBeTruthy();
  }));
});
