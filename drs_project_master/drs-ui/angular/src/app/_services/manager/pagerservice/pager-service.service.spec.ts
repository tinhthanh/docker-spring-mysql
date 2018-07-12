import { TestBed, inject } from '@angular/core/testing';

import { PagerServiceService } from './pager-service.service';

describe('PagerServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PagerServiceService]
    });
  });

  it('should be created', inject([PagerServiceService], (service: PagerServiceService) => {
    expect(service).toBeTruthy();
  }));
});
