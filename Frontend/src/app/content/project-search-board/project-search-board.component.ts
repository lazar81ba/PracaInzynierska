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
  public selectedTags: Tag[] = [];

  constructor(private projectService: ProjectService, private tagService: TagService) { }



  private autocomplete_chips_jquery() {
    const test = (x) => {
      this.addToTagList(x[0].M_Chips.chipsData).forEach(
        (tag) => {
           if (!this.selectedTags.includes(tag)) {
             this.selectedTags.push(tag);
           }
        }
      );
      this.filterProjectList();
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

  filterProjectList() {
    if (this.selectedTags.length > 0) {
      const newProjectList: ProjectGeneral[] = [];

      this.projectList.forEach(
        (project) => {
          let numberOfTagOccurrence = 0;
          this.selectedTags.forEach(
            (selectedTag) => {
              project.tags.forEach(
                (projectTag) => {
                  if (selectedTag.id === projectTag.id
                    && selectedTag.name === projectTag.name) {
                    numberOfTagOccurrence++;
                  }
                }
              );
            }
          );
          if (numberOfTagOccurrence === this.selectedTags.length) {
            newProjectList.push(project);
          }
        }
      );
      this.projectList = newProjectList;
    }
  }

  addToTagList(x): Tag[] {
    const listTag: Tag[] = [];
    x.map((chip) => {
      this.tagList.forEach((tag) => {
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
        this.filterProjectList();

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
