import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpreendimentoComponent } from './empreendimento.component';

describe('EmpreendimentoComponent', () => {
  let component: EmpreendimentoComponent;
  let fixture: ComponentFixture<EmpreendimentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpreendimentoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpreendimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
