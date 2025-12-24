import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RouteExampleTwo } from './route-example-two';

describe('RouteExampleTwo', () => {
  let component: RouteExampleTwo;
  let fixture: ComponentFixture<RouteExampleTwo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouteExampleTwo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RouteExampleTwo);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
