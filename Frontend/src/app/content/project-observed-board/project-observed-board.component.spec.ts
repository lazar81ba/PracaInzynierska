import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectObservedBoardComponent } from './project-observed-board.component';

describe('ProjectObservedBoardComponent', () => {
  let component: ProjectObservedBoardComponent;
  let fixture: ComponentFixture<ProjectObservedBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectObservedBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectObservedBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
