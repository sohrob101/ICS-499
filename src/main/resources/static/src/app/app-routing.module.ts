import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ScoreListComponent} from './components/score-list/score-list.component';
import {NewGameComponent} from './components/new-game/new-game.component';
import { AdminListComponent } from './components/admin-list/admin-list.component';
import {LoginComponent} from "./components/login/login.component";


const routes: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full' },
 { path: 'newGame', component: NewGameComponent },
  { path: 'bestScores', component: ScoreListComponent },
  { path: 'admin', component: LoginComponent },
    { path: 'login', component: LoginComponent }
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
