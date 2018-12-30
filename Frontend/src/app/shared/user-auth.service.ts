import {Injectable} from '@angular/core';
import {AuthorizationData} from '../model/AuthorizationData';
import {Subject} from 'rxjs/Subject';

@Injectable()
export class UserAuthService {

  authorization: AuthorizationData[] = [
    new AuthorizationData('test@gmail.com', 'test'),
    new AuthorizationData('test1@gmail.com', 'test'),
    new AuthorizationData('test2@gmail.com', 'test'),
  ];

  private authorizedData: AuthorizationData;
  private authorized = false;
  public authorizationSubject = new Subject<boolean>();

   isAuthorized(): boolean {
    return this.authorized;
  }

  getAuthorizedEmail(): string {
     return this.authorizedData.email;
  }

  authorize(email: string, password: string): boolean {
    for (const data of this.authorization) {
      if (data.email === email && data.password === password) {
        this.authorizedData = data;
        this.authorized = true;
        this.authorizationSubject.next(true);
        return true;
      }
    }
    return false;
  }

}
