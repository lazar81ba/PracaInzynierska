import {HttpClient, HttpParams} from '@angular/common/http';
import {UserAuthService} from './user-auth.service';
import {UserGeneral} from '../model/UserGeneral';
import {Subject} from 'rxjs/Subject';
import {User} from '../model/User';
import {Injectable} from '@angular/core';

@Injectable()
export class UserService {
  constructor(private httpClient: HttpClient) {}

  public userSubject = new Subject<User>();
  public usersListSubject = new Subject<User[]>();


  private endpointPrefix = 'http://localhost:8080';
  private endpointUser = '/user';
  private endpointUsers = '/users';


  public getUser(user: UserGeneral) {
    this.httpClient.get(this.endpointPrefix + this.endpointUser + '/' + user.email)
      .subscribe((data: User) => {
        this.userSubject.next(data);
      });
  }

  public getUsersByNameAndSurname(user: UserGeneral) {
    const params = new HttpParams().set('name', user.name).set('surname', user.surname);
    this.httpClient.get(this.endpointPrefix + this.endpointUsers, {params})
      .subscribe((data: User[]) => {
        this.usersListSubject.next(data);
      });
  }

}
