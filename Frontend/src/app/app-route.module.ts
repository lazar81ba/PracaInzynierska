import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainpageComponent} from './content/mainpage/mainpage.component';
import {AuthorizationComponent} from './content/authorization/authorization.component';
import {RegistrationComponent} from './content/registration/registration.component';

const appRoutes: Routes = [
  { path: '', component: MainpageComponent },
  { path: 'login', component: AuthorizationComponent},
  { path: 'register', component: RegistrationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRouteModule {

}
