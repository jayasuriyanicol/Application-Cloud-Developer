
import { ConcactButton } from './contact-button';

describe('ConcactButton', () => {
  let component: ConcactButton;
  let fixture: ComponentFixture<ConcactButton>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConcactButton],
    }).compileComponents();

    fixture = TestBed.createComponent(ConcactButton);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
