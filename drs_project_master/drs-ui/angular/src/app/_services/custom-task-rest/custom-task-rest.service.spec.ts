import { TestBed, inject } from '@angular/core/testing';

import { CustomTaskRestService } from './custom-task-rest.service';

describe('CustomTaskRestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CustomTaskRestService]
    });
  });

  it('should be created', inject([CustomTaskRestService], (service: CustomTaskRestService) => {
    expect(service).toBeTruthy();
  }));
});
