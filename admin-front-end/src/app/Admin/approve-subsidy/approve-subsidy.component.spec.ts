import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveSubsidyComponent } from './approve-subsidy.component';

describe('ApproveSubsidyComponent', () => {
  let component: ApproveSubsidyComponent;
  let fixture: ComponentFixture<ApproveSubsidyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApproveSubsidyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveSubsidyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
