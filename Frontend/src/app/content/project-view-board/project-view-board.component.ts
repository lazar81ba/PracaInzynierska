import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../shared/project.service';
import {Project} from '../../model/Project';
import {ProjectGeneral} from '../../model/ProjectGeneral';

declare var $: any;


@Component({
  selector: 'app-project-view-board',
  templateUrl: './project-view-board.component.html',
  styleUrls: ['./project-view-board.component.css']
})
export class ProjectViewBoardComponent implements OnInit {

  constructor(private projectService: ProjectService ) { }

  public currentProject: Project;
  public observedProjects: ProjectGeneral[];
  public isProjectInObservable = false;

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
      }
    );
    this.projectService.observedProjectsSubject.subscribe(
      (data: ProjectGeneral[]) => {
        this.observedProjects = data;
      }
    );
    this.projectService.getObservedProjects();
  }

  isProjectInUserObservedList() {
    if (this.observedProjects != null) {
      const object = this.observedProjects.find( (x) => x.id === this.currentProject.id );
      if (object !== null) {
        return true;
      }
    }
    return false;
  }
}
