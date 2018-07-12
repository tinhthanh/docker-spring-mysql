import { TestBed, inject } from '@angular/core/testing';

import { MenuLoadingService } from './menu-loading.service';

describe('MenuLoadingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MenuLoadingService]
    });
  });

  it('should be created', inject([MenuLoadingService], (service: MenuLoadingService) => {
    expect(service).toBeTruthy();
  }));
});
