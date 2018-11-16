import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAccountBoardComponent } from './user-account-board.component';

describe('UserAccountBoardComponent', () => {
  let component: UserAccountBoardComponent;
  let fixture: ComponentFixture<UserAccountBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserAccountBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserAccountBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
