import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportedVideosComponent } from './reported-videos.component';

describe('ReportedVideosComponent', () => {
  let component: ReportedVideosComponent;
  let fixture: ComponentFixture<ReportedVideosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportedVideosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportedVideosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
