import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectViewBoardComponent } from './project-view-board.component';

describe('ProjectViewBoardComponent', () => {
  let component: ProjectViewBoardComponent;
  let fixture: ComponentFixture<ProjectViewBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectViewBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectViewBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
