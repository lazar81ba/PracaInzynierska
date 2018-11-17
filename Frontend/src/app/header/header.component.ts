import { Component, OnInit } from '@angular/core';
import {UserAuthService} from '../shared/user-auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private userAuth: UserAuthService) { }

  ngOnInit() {
  }

  userLoggedIn() {
    return this.userAuth.isAuthorized();
  }

}
