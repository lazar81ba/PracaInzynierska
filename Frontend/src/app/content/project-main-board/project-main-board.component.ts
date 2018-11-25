import { Component, OnInit } from '@angular/core';
import {User} from '../../model/User';
import {ProjectService} from '../../shared/project.service';
import {ProjectGeneral} from '../../model/ProjectGeneral';
declare var $: any;


@Component({
  selector: 'app-main-board',
  templateUrl: './project-main-board.component.html',
  styleUrls: ['./project-main-board.component.css']
})
export class ProjectMainBoardComponent implements OnInit {


  constructor(private projectService: ProjectService) { }

  public projectList: ProjectGeneral[];

  materialbox_jquery() {
    $(document).ready(function() {
      $('.materialboxed').materialbox();
    });
  }

  ngOnInit() {
    this.projectService.projectsGeneralSubject.subscribe(
      (data: ProjectGeneral[]) => {
        this.projectList = data;
        this.materialbox_jquery();
      }
    );
    this.projectService.getAllProjects();
  }

}
