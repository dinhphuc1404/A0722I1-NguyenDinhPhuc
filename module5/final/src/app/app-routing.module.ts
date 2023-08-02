import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './benh-an/list/list.component';
import {EditComponent} from './benh-an/edit/edit.component';


const routes: Routes = [
  {path: 'benhAn/list', component: ListComponent},
  {path: 'benhAn/edit/:id', component: EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
