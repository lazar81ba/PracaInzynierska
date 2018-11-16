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
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
