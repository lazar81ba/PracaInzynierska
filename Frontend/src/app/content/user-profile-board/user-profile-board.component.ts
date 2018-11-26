import {AfterViewChecked, Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {UserService} from '../../shared/user.service';
import {User} from '../../model/User';
import {UserGeneral} from '../../model/UserGeneral';
import {UserAuthService} from '../../shared/user-auth.service';
import {ProjectService} from '../../shared/project.service';
declare var $: any;


@Component({
  selector: 'app-user-profile-board',
  templateUrl: './user-profile-board.component.html',
  styleUrls: ['./user-profile-board.component.css']
})
export class UserProfileBoardComponent implements OnInit {

  constructor(private projectService: ProjectService, private userService: UserService, private authService: UserAuthService) { }

  public currentUser: User;
  public generalUser: UserGeneral;


   materialbox_jquery() {
     $(document).ready(function() {
       $('.materialboxed').materialbox();
     });
   }


   showProject(id: number) {
      this.projectService.getProject(id);
   }

  ngOnInit() {
    this.userService.userSubject.subscribe(
      (data: User) => {
        this.currentUser = data;
        this.materialbox_jquery();
      }
    );
    if (this.generalUser != null) {
      this.userService.getUser(this.generalUser.email);
    } else {
      this.userService.getUser(this.authService.getAuthorizedEmail());
    }

  }






}
