import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainPageComponent} from './content/main-page/main-page.component';
import {AuthorizationComponent} from './content/authorization/authorization.component';
import {RegistrationComponent} from './content/registration/registration.component';

const appRoutes: Routes = [
  { path: '', component: MainPageComponent },
  { path: 'login', component: AuthorizationComponent},
  { path: 'register', component: RegistrationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRouteModule {

}
