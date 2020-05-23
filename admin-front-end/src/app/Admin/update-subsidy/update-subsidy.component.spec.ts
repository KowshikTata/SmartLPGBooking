import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSubsidyComponent } from './update-subsidy.component';

describe('UpdateSubsidyComponent', () => {
  let component: UpdateSubsidyComponent;
  let fixture: ComponentFixture<UpdateSubsidyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateSubsidyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateSubsidyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
