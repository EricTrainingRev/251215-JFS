import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokeMove } from './poke-move';

describe('PokeMove', () => {
  let component: PokeMove;
  let fixture: ComponentFixture<PokeMove>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PokeMove]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PokeMove);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
