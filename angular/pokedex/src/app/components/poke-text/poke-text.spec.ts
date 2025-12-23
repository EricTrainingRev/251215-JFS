import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokeText } from './poke-text';

describe('PokeText', () => {
  let component: PokeText;
  let fixture: ComponentFixture<PokeText>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PokeText]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PokeText);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
