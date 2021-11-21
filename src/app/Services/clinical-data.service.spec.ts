import { TestBed } from '@angular/core/testing';

import { ClinicalDataService } from './clinical-data.service';

describe('ClinicalDataService', () => {
  let service: ClinicalDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClinicalDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
