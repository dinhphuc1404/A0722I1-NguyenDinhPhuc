import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './vat-tu/list/list.component';
import {SelectComponent} from './vat-tu/select/select.component';
import {UpdateSelectComponent} from './vat-tu/update-select/update-select.component';


const routes: Routes = [
  {path: 'vatTu/list', component: ListComponent},
  {path: 'select/list', component: SelectComponent},
  {path: 'select/update/:id', component: UpdateSelectComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
