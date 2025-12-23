import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokeType } from './poke-type';

describe('PokeType', () => {
  let component: PokeType;
  let fixture: ComponentFixture<PokeType>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PokeType]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PokeType);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
