import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';
import {UserAuthService} from '../../shared/user-auth.service';

@Component({
  selector: 'app-authorization',
  templateUrl: './authorization.component.html',
  styleUrls: ['./authorization.component.css']
})
export class AuthorizationComponent implements OnInit {

  authorized: boolean;
  error = false;

  constructor(private userAuth: UserAuthService, private router: Router) { }

  ngOnInit() {
  }

  onSignIn(f: NgForm) {
    const email = f.value.email;
    const pass = f.value.password;
    this.authorized = this.userAuth.authorize(email, pass);
    if (this.authorized) {
      this.router.navigate(['/project']);
    } else {
      this.error = true;
    }
  }
}
