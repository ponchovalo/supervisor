import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreventivosComponent } from './preventivos.component';

describe('PreventivosComponent', () => {
  let component: PreventivosComponent;
  let fixture: ComponentFixture<PreventivosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PreventivosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PreventivosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
