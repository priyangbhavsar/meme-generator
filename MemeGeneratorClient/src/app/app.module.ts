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

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    ExploreMemeComponent,
    ButtonComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [
  ]
})
export class AppModule { }
