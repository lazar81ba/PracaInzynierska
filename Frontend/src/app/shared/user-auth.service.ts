import {User} from '../model/User';


export class UserAuthService {

  users: User[] = [
    new User('Andrzej', 'Kot', 'test', 'test@gmail.com')
  ];

  private loggedUser: User;
  private authorized = false;

  get isAuthorized(): boolean {
    return this.authorized;
  }

  authorize(email: string, password: string) {
    for (const user of this.users) {
      if (user.email === email && user.password === password) {
        this.loggedUser = user;
        this.authorized = true;
        return true;
      }
    }
    return false;
  }

}
