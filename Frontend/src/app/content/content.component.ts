import { Component, OnInit } from '@angular/core';
import {UserAuthService} from '../shared/user-auth.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  constructor(public authService: UserAuthService) { }

  public authorized = false;

  ngOnInit() {
    this.authService.authorizationSubject.subscribe(
      (data: boolean) => {
        this.authorized = data;
      }
    );
  }

}
