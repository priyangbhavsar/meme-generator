import { ExploreMemeComponent } from './components/explore-meme/explore-meme.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditModalComponent } from './components/common-components/modal-components/edit-modal/edit-modal.component';

const routes: Routes = [
  {
    path: '',
    component: DashboardComponent
  },
  {
    path: 'explore',
    component: ExploreMemeComponent
  },
  {
    path: 'edit',
    component: EditModalComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
