import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateGasCostComponent } from './update-gas-cost.component';

describe('UpdateGasCostComponent', () => {
  let component: UpdateGasCostComponent;
  let fixture: ComponentFixture<UpdateGasCostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateGasCostComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateGasCostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
