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
import {UserProfileBoardComponent} from './content/user-profile-board/user-profile-board.component';
import {ProjectMainBoardComponent} from './content/project-main-board/project-main-board.component';
import {ProjectCreateBoardComponent} from './content/project-create-board/project-create-board.component';
import {ProjectSearchBoardComponent} from './content/project-search-board/project-search-board.component';
import {ProjectViewBoardComponent} from './content/project-view-board/project-view-board.component';
import {UserAccountBoardComponent} from './content/user-account-board/user-account-board.component';


@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    AuthorizationComponent,
    RegistrationComponent,
    HeaderComponent,
    ContentComponent,
    UserProfileBoardComponent,
    ProjectMainBoardComponent,
    ProjectCreateBoardComponent,
    ProjectSearchBoardComponent,
    ProjectViewBoardComponent,
    UserAccountBoardComponent
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
