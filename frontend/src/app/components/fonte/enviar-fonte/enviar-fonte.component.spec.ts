import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnviarFonteComponent } from './enviar-fonte.component';

describe('EnviarFonteComponent', () => {
  let component: EnviarFonteComponent;
  let fixture: ComponentFixture<EnviarFonteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnviarFonteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnviarFonteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
