import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestSubsidyComponent } from './request-subsidy.component';

describe('RequestSubsidyComponent', () => {
  let component: RequestSubsidyComponent;
  let fixture: ComponentFixture<RequestSubsidyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestSubsidyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestSubsidyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
