import {Injectable} from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {ProjectGeneral} from '../model/ProjectGeneral';
import {User} from '../model/User';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ProjectService {
  constructor(private httpClient: HttpClient) {}

  private projectEndpoint = 'http://localhost:8080/project';

  public projectsGeneralSubject = new Subject<ProjectGeneral[]>();

  public getAllProjects() {
    this.httpClient.get(this.projectEndpoint)
      .subscribe((data: ProjectGeneral[]) => {
        this.projectsGeneralSubject.next(data);
      });
  }

}
