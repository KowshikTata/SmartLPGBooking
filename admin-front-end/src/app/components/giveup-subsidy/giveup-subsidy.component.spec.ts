import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GiveupSubsidyComponent } from './giveup-subsidy.component';

describe('GiveupSubsidyComponent', () => {
  let component: GiveupSubsidyComponent;
  let fixture: ComponentFixture<GiveupSubsidyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GiveupSubsidyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GiveupSubsidyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
