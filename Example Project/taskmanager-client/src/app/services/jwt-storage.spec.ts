import { TestBed } from '@angular/core/testing';

import { JwtStorage } from './jwt-storage';

describe('JwtStorage', () => {
  let service: JwtStorage;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JwtStorage);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
