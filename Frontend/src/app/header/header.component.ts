import {AfterContentInit, AfterViewChecked, AfterViewInit, Component, OnChanges, OnInit} from '@angular/core';
import {UserAuthService} from '../shared/user-auth.service';

declare var $: any;

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements  OnChanges, AfterViewInit{

  constructor(private userAuth: UserAuthService) { }


  sidenav_jquery() {
    $(document).ready(function() {
      $('.sidenav').sidenav();
    });
  }

  userLoggedIn() {
    return this.userAuth.isAuthorized();
  }

  ngOnChanges(): void {
    this.sidenav_jquery();
  }

  ngAfterViewInit(): void {
    this.sidenav_jquery();
  }

}
