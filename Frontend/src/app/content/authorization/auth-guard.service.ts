import {CanActivate, Router} from '@angular/router';
import {UserAuthService} from '../../shared/user-auth.service';
import {Injectable} from '@angular/core';

@Injectable()
export class AuthGuardService implements CanActivate {
  constructor(public userAuth: UserAuthService, public router: Router) {}

  canActivate(): boolean {
    if (!this.userAuth.isAuthorized()) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }

}
