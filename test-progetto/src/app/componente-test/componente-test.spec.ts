import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteTest } from './componente-test';

describe('ComponenteTest', () => {
  let component: ComponenteTest;
  let fixture: ComponentFixture<ComponenteTest>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComponenteTest],
    }).compileComponents();

    fixture = TestBed.createComponent(ComponenteTest);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
