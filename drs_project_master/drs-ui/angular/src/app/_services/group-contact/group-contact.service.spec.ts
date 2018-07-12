import { TestBed, inject } from '@angular/core/testing';

import { GroupContactService } from './group-contact.service';

describe('GroupContactService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GroupContactService]
    });
  });

  it('should be created', inject([GroupContactService], (service: GroupContactService) => {
    expect(service).toBeTruthy();
  }));
});
