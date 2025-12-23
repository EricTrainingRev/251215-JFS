import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokeSprites } from './poke-sprites';

describe('PokeSprites', () => {
  let component: PokeSprites;
  let fixture: ComponentFixture<PokeSprites>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PokeSprites]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PokeSprites);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
