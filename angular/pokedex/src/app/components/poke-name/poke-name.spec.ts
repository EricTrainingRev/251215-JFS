import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokeName } from './poke-name';

describe('PokeName', () => {
  let component: PokeName;
  let fixture: ComponentFixture<PokeName>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PokeName]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PokeName);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
