import { TestBed } from '@angular/core/testing';

import { SubsidyService } from './subsidy.service';

describe('SubsidyService', () => {
  let service: SubsidyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubsidyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
