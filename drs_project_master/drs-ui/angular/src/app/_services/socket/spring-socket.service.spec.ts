import { TestBed, inject } from '@angular/core/testing';

import { SpringSocketService } from './spring-socket.service';

describe('SpringSocketService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SpringSocketService]
    });
  });

  it('should be created', inject([SpringSocketService], (service: SpringSocketService) => {
    expect(service).toBeTruthy();
  }));
});
