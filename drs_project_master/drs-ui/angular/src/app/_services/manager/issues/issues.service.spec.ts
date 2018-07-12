import { TestBed, inject } from '@angular/core/testing';

import { IssuesService } from './issues.service';

describe('IssuesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [IssuesService]
    });
  });

  it('should be created', inject([IssuesService], (service: IssuesService) => {
    expect(service).toBeTruthy();
  }));
});
