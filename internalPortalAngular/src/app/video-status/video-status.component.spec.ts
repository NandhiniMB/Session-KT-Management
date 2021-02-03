import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VideoStatusComponent } from './video-status.component';

describe('VideoStatusComponent', () => {
  let component: VideoStatusComponent;
  let fixture: ComponentFixture<VideoStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VideoStatusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VideoStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
