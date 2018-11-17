import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectMainBoardComponent } from './project-main-board.component';

describe('ProjectMainBoardComponent', () => {
  let component: ProjectMainBoardComponent;
  let fixture: ComponentFixture<ProjectMainBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectMainBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectMainBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
