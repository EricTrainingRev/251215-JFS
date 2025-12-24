import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RouteExample } from './route-example';

describe('RouteExample', () => {
  let component: RouteExample;
  let fixture: ComponentFixture<RouteExample>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouteExample]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RouteExample);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
