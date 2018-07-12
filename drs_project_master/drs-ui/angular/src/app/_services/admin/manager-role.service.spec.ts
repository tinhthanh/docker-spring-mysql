import { TestBed, inject } from '@angular/core/testing';

import { ManagerRoleService } from './manager-role.service';

describe('ManagerRoleService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ManagerRoleService]
    });
  });

  it('should be created', inject([ManagerRoleService], (service: ManagerRoleService) => {
    expect(service).toBeTruthy();
  }));
});
