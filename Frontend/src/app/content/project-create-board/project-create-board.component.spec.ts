import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectCreateBoardComponent } from './project-create-board.component';

describe('ProjectCreateBoardComponent', () => {
  let component: ProjectCreateBoardComponent;
  let fixture: ComponentFixture<ProjectCreateBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectCreateBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectCreateBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
