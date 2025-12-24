import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokedexButton } from './pokedex-button';

describe('PokedexButton', () => {
  let component: PokedexButton;
  let fixture: ComponentFixture<PokedexButton>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PokedexButton]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PokedexButton);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
