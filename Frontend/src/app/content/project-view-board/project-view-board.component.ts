import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../shared/project.service';
import {Project} from '../../model/Project';

declare var $: any;


@Component({
  selector: 'app-project-view-board',
  templateUrl: './project-view-board.component.html',
  styleUrls: ['./project-view-board.component.css']
})
export class ProjectViewBoardComponent implements OnInit {

  constructor(private projectService: ProjectService) { }

  public currentProject: Project;

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
      }
    );
  }

}
