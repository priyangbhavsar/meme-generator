import { MatFormFieldModule } from '@angular/material/form-field';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { MatInputModule } from '@angular/material/input';
import { ExploreMemeComponent } from './components/explore-meme/explore-meme.component';
import { HttpClientModule } from '@angular/common/http';
import { ButtonComponentComponent } from './components/common-components/button-component/button-component.component';
import { SidebarComponent } from './components/common-components/sidebar-component/sidebar.component';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';
import { LoaderComponent } from './components/common-components/loader-component/loader.component';
import { EditModalComponent } from './components/common-components/modal-components/edit-modal/edit-modal.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatNativeDateModule} from '@angular/material/core';
import {MaterialExampleModule} from '../material.module';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    ExploreMemeComponent,
    ButtonComponentComponent,
    SidebarComponent,
    LoaderComponent,
    EditModalComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule,
    CKEditorModule,
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
    MaterialExampleModule,
    ReactiveFormsModule,

  ],
  providers: [
  ],
  bootstrap: [AppComponent],
  exports: [
  ],
  entryComponents: [
    DashboardComponent,
    EditModalComponent
  ]
})
export class AppModule { }
