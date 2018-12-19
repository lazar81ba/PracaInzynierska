import { Component, OnInit } from '@angular/core';
import {ProjectDetail} from '../../model/ProjectDetail';
import {Link} from '../../model/Link';
import {Tag} from '../../model/Tag';
import {TagService} from '../../shared/tag.service';
import {ProjectService} from '../../shared/project.service';
import {CreateProjectRequest} from '../../model/request/CreateProjectRequest';
declare var $: any;


@Component({
  selector: 'app-project-create-board',
  templateUrl: './project-create-board.component.html',
  styleUrls: ['./project-create-board.component.css']
})
export class ProjectCreateBoardComponent implements OnInit {

  public projectDetails: ProjectDetail[] = [];
  public projectLinks: Link[] = [];
  public tagList: Tag[];
  public selectedTags: Tag[] = [];
  public imageUrl = '';
  public projectName = '';
  public description = '';
  public isPublic = true;

  constructor(private projectService: ProjectService, private tagService: TagService) { }

  character_count_jquery() {
    $(document).ready(function() {
      $('input#project_name, textarea#description, input#projectDetailsText, input#projectLinkText').characterCounter();
    });
  }


  materialbox_jquery() {
    $(document).ready(function() {
      $('.materialboxed').materialbox();
    });
  }

  private autocomplete_chips_jquery() {
    const test = (x) => {
      this.addToTagList(x[0].M_Chips.chipsData).forEach(
        (tag) => {
          if (this.selectedTags.find( el => el.name == tag.name) === undefined ) {
            this.selectedTags.push(tag);
          }
        }
      );
    };


    const chipData = this.convertTagListToChipObject();
    $( document ).ready(function() {
      $('.chips-autocomplete').chips({
        placeholder: 'Enter a tag',
        onChipAdd: test,
        autocompleteOptions: {
          data: chipData,
          limit: Infinity,
          minLength: 1
        }
      });
    });

  }

  addToTagList(x): Tag[] {
    const listTag: Tag[] = [];
    x.map((chip) => {
      let isNewTag = true;
      this.tagList.forEach((tag) => {
        if (tag.name === chip.tag) {
          listTag.push(tag);
          isNewTag = false;
        }
      });
      if (isNewTag) {
        listTag.push(new Tag(0, chip.tag));
      }
    });
    return listTag;
  }


  private convertTagListToChipObject() {
    const chip = {};
    this.tagList.map((x) =>
      chip[x.name] = null
    );
    return chip;
  }

  ngOnInit() {
    this.character_count_jquery();
    this.tagService.tagSubject.subscribe(
      (data: Tag[]) => {
        this.tagList = data;
        this.autocomplete_chips_jquery();
      }
    );
    this.tagService.getAllTags();
  }

  addDetail(value: string) {
    this.projectDetails.push(new ProjectDetail(this.projectDetails.length + 1, value));
  }

  addLink(value: string) {
    this.projectLinks.push(new Link(this.projectLinks.length + 1, value));
  }

  addImage(value: string) {
    this.imageUrl = value;
    this.materialbox_jquery();
  }

  onClickSubmit() {
    this.projectService.createProject( new CreateProjectRequest(
      this.projectName,
      this.description,
      this.imageUrl,
      this.isPublic,
      this.projectDetails,
      this.projectLinks,
      this.selectedTags));
  }

  resetCustomForm() {
    this.projectDetails = [];
    this.projectLinks = [];
    this.selectedTags = [];
    this.imageUrl = '';
    this.projectName = '';
    this.description = '';
  }

  validForm() {
    return this.projectLinks.length !== 0
      && this.projectDetails.length !== 0
      && this.selectedTags.length !== 0
      && this.imageUrl != ''
      && this.projectName != ''
      && this.description != '';
  }
}
