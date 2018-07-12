import { TestBed, inject } from '@angular/core/testing';

import { ShareFiltersService } from './share-filters.service';

describe('ShareFiltersService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ShareFiltersService]
    });
  });

  it('should be created', inject([ShareFiltersService], (service: ShareFiltersService) => {
    expect(service).toBeTruthy();
  }));
});
