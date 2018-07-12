import { TestBed, inject } from '@angular/core/testing';

import { ListenDataService } from './listen-data.service';

describe('ListenDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListenDataService]
    });
  });

  it('should be created', inject([ListenDataService], (service: ListenDataService) => {
    expect(service).toBeTruthy();
  }));
});
