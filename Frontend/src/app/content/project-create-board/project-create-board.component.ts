import { Component, OnInit } from '@angular/core';
import {ProjectDetail} from '../../model/ProjectDetail';
import {Link} from '../../model/Link';
import {Tag} from '../../model/Tag';
import {TagService} from '../../shared/tag.service';
import {ProjectService} from '../../shared/project.service';
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
  public selectedTags: Tag[];
  public imageUrl = '';

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

  autocomplete_chips_jquery() {
    const test = (x) => {
      this.addToTagList(x[0].M_Chips.chipsData, this.tagList).forEach(
        (tag) => {
          this.selectedTags.push(tag);
        }
      );
    };
    const chipData = this.convertTagListToChipbject();
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

  addToTagList(x, list): Tag[] {
    const listTag: Tag[] = [];
    x.map((chip) => {
      list.forEach((tag) => {
        if (tag.name === chip.tag) {
          listTag.push(tag);
        }
      });
    });
    return listTag;
  }


  private convertTagListToChipbject() {
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

  onClickSubmit(data) {
    const data1 = data;
  }

  resetCustomForm() {
    this.projectDetails = [];
    this.projectLinks = [];
    this.selectedTags = [];
    this.imageUrl = '';
  }

}
