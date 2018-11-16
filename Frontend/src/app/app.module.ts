import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MainPageComponent } from './content/main-page/main-page.component';
import {AppRouteModule} from './app-route.module';
import { AuthorizationComponent } from './content/authorization/authorization.component';
import { RegistrationComponent } from './content/registration/registration.component';
import { HeaderComponent } from './header/header.component';
import { ContentComponent } from './content/content.component';
import {FormsModule} from '@angular/forms';
import {UserAuthService} from './shared/user-auth.service';
import {AuthGuardService} from './content/authorization/auth-guard.service';
import {ProjectBoardComponent} from './content/project-board/project-board.component';
import {UserProfileBoardComponent} from './content/user-profile-board/user-profile-board.component';
import {MainBoardComponent} from './content/mainboard/main-board.component';


@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    AuthorizationComponent,
    RegistrationComponent,
    HeaderComponent,
    ContentComponent,
    ProjectBoardComponent,
    UserProfileBoardComponent,
    MainBoardComponent
  ],
  imports: [
    BrowserModule,
    AppRouteModule,
    FormsModule
  ],
  providers: [UserAuthService, AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
