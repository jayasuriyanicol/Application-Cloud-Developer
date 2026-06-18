import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Provacomponent } from './provacomponent';

describe('Provacomponent', () => {
  let component: Provacomponent;
  let fixture: ComponentFixture<Provacomponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Provacomponent],
    }).compileComponents();

    fixture = TestBed.createComponent(Provacomponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
