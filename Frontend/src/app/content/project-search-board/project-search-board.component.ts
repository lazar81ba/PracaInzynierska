import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../shared/project.service';
import {ProjectGeneral} from '../../model/ProjectGeneral';
import {Tag} from '../../model/Tag';
import {Chip} from '../../model/Chip';
import {TagService} from '../../shared/tag.service';
declare var $: any;


@Component({
  selector: 'app-project-search-board',
  templateUrl: './project-search-board.component.html',
  styleUrls: ['./project-search-board.component.css']
})
export class ProjectSearchBoardComponent implements OnInit {
  public projectList: ProjectGeneral[];
  public tagList: Tag[];
  public selectedTags: Tag[];

  constructor(private projectService: ProjectService, private tagService: TagService) { }



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
    this.tagService.tagSubject.subscribe(
      (data: Tag[]) => {
        this.tagList = data;
        this.autocomplete_chips_jquery();
      }
    );
    this.tagService.getAllTags();
  }

  search(value: string) {
    this.projectService.getProjectsByName(value);
  }

  showProject(id: number) {
    this.projectService.getProject(id);
  }
}
