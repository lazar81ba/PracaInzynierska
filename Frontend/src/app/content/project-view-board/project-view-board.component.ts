import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../shared/project.service';
import {Project} from '../../model/Project';
import {ProjectGeneral} from '../../model/ProjectGeneral';
import {UserService} from '../../shared/user.service';
import {UserAuthService} from '../../shared/user-auth.service';
import {Router} from '@angular/router';

declare var $: any;


@Component({
  selector: 'app-project-view-board',
  templateUrl: './project-view-board.component.html',
  styleUrls: ['./project-view-board.component.css']
})
export class ProjectViewBoardComponent implements OnInit {

  constructor(private projectService: ProjectService, private userService: UserService, private userAuthService: UserAuthService, private router: Router) { }

  public currentProject: Project;
  public observedProjects: ProjectGeneral[];
  public isProjectInObservable = false;
  public isCurrentUserParticipator;

  materialbox_jquery() {
    $(document).ready(function() {
      $('.materialboxed').materialbox();
    });
  }


  ngOnInit() {
    this.projectService.projectToViewSubject.subscribe(
      (data: Project) => {
        this.currentProject = data;
        this.materialbox_jquery();
        this.isProjectInObservable = this.isProjectInUserObservedList();
        this.isCurrentUserParticipator = this.isCurrentUserInParticipatorList();
      }
    );
    this.projectService.observedProjectsSubject.subscribe(
      (data: ProjectGeneral[]) => {
        this.observedProjects = data;
        this.isProjectInObservable = this.isProjectInUserObservedList();
        this.router.initialNavigation();
      }
    );
    this.projectService.getCurrentObservedProjects();
  }

  isProjectInUserObservedList() {
    if (this.observedProjects !== undefined && this.currentProject !== undefined) {
      const object = this.observedProjects.find( (x) => x.id === this.currentProject.id );
      if (object !== undefined) {
        return true;
      }
    }
    return false;
  }

  isCurrentUserInParticipatorList() {
    if (this.currentProject != null) {
      const object = this.currentProject.participators.find((x) => x.email === this.userAuthService.getAuthorizedEmail());
      if (object !== undefined) {
        return true;
      }
    }
    return false;
  }

  addProjectToObservedList() {
    this.projectService.subscribeProject(this.currentProject.id);
  }

  removeProjectFromObservedList() {
    this.projectService.unsubscribeProject(this.currentProject.id);
  }

  showUser(email: string) {
    this.userService.getUser(email);
  }
}
