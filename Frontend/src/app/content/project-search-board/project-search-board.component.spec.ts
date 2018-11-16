import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectSearchBoardComponent } from './project-search-board.component';

describe('ProjectSearchBoardComponent', () => {
  let component: ProjectSearchBoardComponent;
  let fixture: ComponentFixture<ProjectSearchBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectSearchBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectSearchBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
