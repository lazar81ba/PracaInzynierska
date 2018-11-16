import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserProfileBoardComponent } from './user-profile-board.component';

describe('UserProfileBoardComponent', () => {
  let component: UserProfileBoardComponent;
  let fixture: ComponentFixture<UserProfileBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserProfileBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserProfileBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
