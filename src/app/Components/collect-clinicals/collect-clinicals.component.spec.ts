import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CollectClinicalsComponent } from './collect-clinicals.component';

describe('CollectClinicalsComponent', () => {
  let component: CollectClinicalsComponent;
  let fixture: ComponentFixture<CollectClinicalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CollectClinicalsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CollectClinicalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
