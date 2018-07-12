import { TestBed, inject } from '@angular/core/testing';

import { NotifyCenterService } from './notify-center.service';

describe('NotifyCenterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NotifyCenterService]
    });
  });

  it('should be created', inject([NotifyCenterService], (service: NotifyCenterService) => {
    expect(service).toBeTruthy();
  }));
});
