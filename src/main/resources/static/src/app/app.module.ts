import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppMaterialModule} from "./app.material-module";
import {ScoreListComponent} from './components/score-list/score-list.component';
import {NewGameComponent} from './components/new-game/new-game.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSortModule} from '@angular/material/sort';
import {FlexLayoutModule} from '@angular/flex-layout';
import { AdminListComponent,DialogComponent } from './components/admin-list/admin-list.component';
import { MatDialogModule, MAT_DIALOG_DEFAULT_OPTIONS } from '@angular/material/dialog';
import { LoginComponent } from './components/login/login.component';
import {AuthapiService} from "./services/authapi.service";



@NgModule({
  declarations: [
    AppComponent,
    ScoreListComponent,
    NewGameComponent,
    AdminListComponent,
    DialogComponent,
    LoginComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AppMaterialModule,
    BrowserAnimationsModule,
    MatSortModule,
    FlexLayoutModule,
    MatDialogModule
  ],

  entryComponents: [
    DialogComponent
  ],


  providers: [
    {provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: {hasBackdrop: false}},
      AuthapiService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
