import { TestBed, inject } from '@angular/core/testing';

import { SendIssuesService } from './send-issues.service';

describe('SendIssuesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SendIssuesService]
    });
  });

  it('should be created', inject([SendIssuesService], (service: SendIssuesService) => {
    expect(service).toBeTruthy();
  }));
});
