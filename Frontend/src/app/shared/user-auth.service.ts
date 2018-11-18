import {Injectable} from '@angular/core';
import {AuthorizationData} from '../model/AuthorizationData';

@Injectable()
export class UserAuthService {

  authorization: AuthorizationData[] = [
    new AuthorizationData('test@gmail.com', 'test')
  ];

  private authorizedData: AuthorizationData;
  private authorized = false;

   isAuthorized(): boolean {
    return this.authorized;
  }

  authorize(email: string, password: string): boolean {
    for (const data of this.authorization) {
      if (data.email === email && data.password === password) {
        this.authorizedData = data;
        this.authorized = true;
        return true;
      }
    }
    return false;
  }

}
