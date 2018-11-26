import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../shared/project.service';
import {ProjectGeneral} from '../../model/ProjectGeneral';

declare var $: any;


@Component({
  selector: 'app-project-observed-board',
  templateUrl: './project-observed-board.component.html',
  styleUrls: ['./project-observed-board.component.css']
})
export class ProjectObservedBoardComponent implements OnInit {

  constructor(private projectService: ProjectService) { }

  public projectList: ProjectGeneral[];

  collapsible_jquery() {
    $(document).ready(function() {
      $('.collapsible').collapsible();
    });
  }

  ngOnInit() {
    this.projectService.observedProjectsSubject.subscribe(
      (data: ProjectGeneral[]) => {
        this.projectList = data;
        this.collapsible_jquery();
      }
    );
    this.projectService.getObservedProjects();
  }

}
