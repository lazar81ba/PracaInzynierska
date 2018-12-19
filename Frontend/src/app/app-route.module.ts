import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainPageComponent} from './content/main-page/main-page.component';
import {AuthorizationComponent} from './content/authorization/authorization.component';
import {AuthGuardService} from './content/authorization/auth-guard.service';
import {ProjectCreateBoardComponent} from './content/project-create-board/project-create-board.component';
import {ProjectViewBoardComponent} from './content/project-view-board/project-view-board.component';
import {UserProfileBoardComponent} from './content/user-profile-board/user-profile-board.component';
import {ProjectMainBoardComponent} from './content/project-main-board/project-main-board.component';
import {ProjectSearchBoardComponent} from './content/project-search-board/project-search-board.component';

const appRoutes: Routes = [
  { path: '', component: MainPageComponent },
  { path: 'login', component: AuthorizationComponent},
  { path: 'project', component: ProjectMainBoardComponent, canActivate: [AuthGuardService]},
  { path: 'project/search', component: ProjectSearchBoardComponent, canActivate: [AuthGuardService]},
  { path: 'project/create', component: ProjectCreateBoardComponent, canActivate: [AuthGuardService]},
  { path: 'project/view', component: ProjectViewBoardComponent, canActivate: [AuthGuardService]},
  { path: 'user/view', component: UserProfileBoardComponent, canActivate: [AuthGuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRouteModule {

}
