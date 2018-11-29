import {Injectable} from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {ProjectGeneral} from '../model/ProjectGeneral';
import {User} from '../model/User';
import {HttpClient, HttpParams} from '@angular/common/http';
import {UserAuthService} from './user-auth.service';
import {Project} from '../model/Project';

@Injectable()
export class ProjectService {
  constructor(private httpClient: HttpClient, private userAuthService: UserAuthService) {}

  private projectEndpoint = 'http://localhost:8080/project';
  private observedProjectsEndpoint = 'http://localhost:8080/user/' + this.userAuthService.getAuthorizedEmail() + '/observedProjects';

  public projectsGeneralSubject = new Subject<ProjectGeneral[]>();
  public observedProjectsSubject = new Subject<ProjectGeneral[]>();
  public projectToViewSubject = new Subject<Project>();

  public getObservedProjects() {
    this.httpClient.get(this.observedProjectsEndpoint)
      .subscribe((data: ProjectGeneral[]) => {
        this.observedProjectsSubject.next(data);
      });
  }

  public getProject(id: number) {
    this.httpClient.get(this.projectEndpoint + '/' + id)
      .subscribe( (data: Project) => {
        this.projectToViewSubject.next(data);
      });
  }

  public getAllProjects() {
    this.httpClient.get(this.projectEndpoint)
      .subscribe((data: ProjectGeneral[]) => {
        this.projectsGeneralSubject.next(data);
      });
  }

  public getProjectsByName(name: string) {
    const params = new HttpParams().set('name', name);
    this.httpClient.get(this.projectEndpoint, {params})
      .subscribe((data: ProjectGeneral[]) => {
        this.projectsGeneralSubject.next(data);
      });
  }

}
