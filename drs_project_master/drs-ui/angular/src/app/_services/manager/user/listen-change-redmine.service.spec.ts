import { TestBed, inject } from '@angular/core/testing';

import { ListenChangeRedmineService } from './listen-change-redmine.service';

describe('ListenChangeRedmineService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListenChangeRedmineService]
    });
  });

  it('should be created', inject([ListenChangeRedmineService], (service: ListenChangeRedmineService) => {
    expect(service).toBeTruthy();
  }));
});
