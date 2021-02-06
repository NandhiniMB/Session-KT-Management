import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscribedCategoriesComponent } from './subscribed-categories.component';

describe('SubscribedCategoriesComponent', () => {
  let component: SubscribedCategoriesComponent;
  let fixture: ComponentFixture<SubscribedCategoriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubscribedCategoriesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscribedCategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
