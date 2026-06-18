import { TestBed } from '@angular/core/testing';

import { ServiceProva } from './service/service-prova';

describe('ServiceProva', () => {
  let service: ServiceProva;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceProva);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
