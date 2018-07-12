import { TestBed, inject } from '@angular/core/testing';

import { ShareIssuesService } from './share-issues.service';

describe('ShareIssuesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ShareIssuesService]
    });
  });

  it('should be created', inject([ShareIssuesService], (service: ShareIssuesService) => {
    expect(service).toBeTruthy();
  }));
});
