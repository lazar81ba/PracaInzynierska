import {Injectable} from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {ProjectGeneral} from '../model/ProjectGeneral';
import {HttpClient, HttpParams} from '@angular/common/http';
import {UserAuthService} from './user-auth.service';
import {Project} from '../model/Project';
import {CreateProjectRequest} from '../model/request/CreateProjectRequest';

@Injectable()
export class ProjectService {
  constructor(private httpClient: HttpClient, private userAuthService: UserAuthService) {}

  private projectEndpoint = 'http://localhost:8080/projects';
  private observedProjectsEndpoint = 'http://localhost:8080/users/' + this.userAuthService.getAuthorizedEmail() + '/observedProjects';

  public projectsGeneralSubject = new Subject<ProjectGeneral[]>();
  public observedProjectsSubject = new Subject<ProjectGeneral[]>();
  private observedProjects: ProjectGeneral[] = [];
  public projectToViewSubject = new Subject<Project>();

  public getObservedProjects() {
    this.httpClient.get(this.observedProjectsEndpoint)
      .subscribe((data: ProjectGeneral[]) => {
        this.observedProjects = data;
        this.observedProjectsSubject.next(data);
      });
  }

  public createProject(project: CreateProjectRequest) {
    this.httpClient.post(this.projectEndpoint, project)
      .subscribe(
        res => {
          console.log('success');
        },
        err => {
          console.log('Error occured');
        }
      );
  }

  public joinProject(projectId: number) {
    this.httpClient.post(this.projectEndpoint + '/' + projectId + '/join',
      {email: this.userAuthService.getAuthorizedEmail()})
      .subscribe(
        res => {
          this.getProject(projectId);
        },
        err => {
          console.log('Error occured');
        }
      );
  }

  public resignProject(projectId: number) {
    this.httpClient.post(this.projectEndpoint + '/' + projectId + '/resign',
      {email: this.userAuthService.getAuthorizedEmail()})
      .subscribe(
        res => {
          this.getProject(projectId);
        },
        err => {
          console.log('Error occured');
        }
      );
  }

  public subscribeProject(projectId: number) {
    this.httpClient.post(this.projectEndpoint + '/' + projectId + '/subscribe',
      {email: this.userAuthService.getAuthorizedEmail()})
      .subscribe(
      res => {
        this.getObservedProjects();
        this.getCurrentObservedProjects();
      },
      err => {
        console.log('Error occured');
      }
    );
  }

  public unsubscribeProject(projectId: number) {
    this.httpClient.post(this.projectEndpoint + '/' + projectId + '/unsubscribe',
      {email: this.userAuthService.getAuthorizedEmail()})
      .subscribe(
        res => {
          this.getObservedProjects();
        },
        err => {
          console.log('Error occured');
        }
      );
  }

  public getCurrentObservedProjects() {
    this.observedProjectsSubject.next(this.observedProjects);
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

  public getRecommendedProjects() {
    this.httpClient.get('http://localhost:8080/users/' + this.userAuthService.getAuthorizedEmail() + '/recommendation')
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
