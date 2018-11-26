import {Injectable} from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {ProjectGeneral} from '../model/ProjectGeneral';
import {User} from '../model/User';
import {HttpClient} from '@angular/common/http';
import {UserAuthService} from './user-auth.service';

@Injectable()
export class ProjectService {
  constructor(private httpClient: HttpClient, private userAuthService: UserAuthService) {}

  private projectEndpoint = 'http://localhost:8080/project';
  private observedProjectsEndpoint = 'http://localhost:8080/user/' + this.userAuthService.getAuthorizedEmail() + '/observedProjects';

  public projectsGeneralSubject = new Subject<ProjectGeneral[]>();
  public observedProjectsSubject = new Subject<ProjectGeneral[]>();


  public getObservedProjects() {
    this.httpClient.get(this.observedProjectsEndpoint)
      .subscribe((data: ProjectGeneral[]) => {
        this.observedProjectsSubject.next(data);
      });
  }

  public getAllProjects() {
    this.httpClient.get(this.projectEndpoint)
      .subscribe((data: ProjectGeneral[]) => {
        this.projectsGeneralSubject.next(data);
      });
  }

}
