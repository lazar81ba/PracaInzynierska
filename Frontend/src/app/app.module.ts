import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MainpageComponent } from './content/mainpage/mainpage.component';
import {AppRouteModule} from './app-route.module';
import { AuthorizationComponent } from './content/authorization/authorization.component';
import { RegistrationComponent } from './content/registration/registration.component';
import { HeaderComponent } from './header/header.component';
import { ContentComponent } from './content/content.component';
import {FormsModule} from '@angular/forms';
import {UserAuthService} from './shared/user-auth.service';
import {AuthGuardService} from './content/authorization/auth-guard.service';


@NgModule({
  declarations: [
    AppComponent,
    MainpageComponent,
    AuthorizationComponent,
    RegistrationComponent,
    HeaderComponent,
    ContentComponent
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
