import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {CustomerCreateComponent} from './customer/customer-create/customer-create.component';
import {CustomerEditComponent} from './customer/customer-edit/customer-edit.component';
import {EmployeeListComponent} from './employee/employee-list/employee-list.component';
import {EmployeeCreateComponent} from './employee/employee-create/employee-create.component';
import {EmployeeEditComponent} from './employee/employee-edit/employee-edit.component';
import {ServiceListComponent} from './serivcetable/service-list/service-list.component';
import {ServiceCreateComponent} from './serivcetable/service-create/service-create.component';
import {ServiceEditComponent} from './serivcetable/service-edit/service-edit.component';
import {ContractCreateComponent} from './contract/contract-create/contract-create.component';
import {ContractListComponent} from './contract/contract-list/contract-list.component';


const routes: Routes = [
  {path: 'customer/list', component: CustomerListComponent},
  {path: 'customer/create', component: CustomerCreateComponent},
  {path: 'customer/edit/:id', component: CustomerEditComponent},
  {path: 'customer/delete/:id', component: CustomerEditComponent},
  {path: 'employee/list', component: EmployeeListComponent},
  {path: 'employee/create', component: EmployeeCreateComponent},
  {path: 'employee/edit/:id', component: EmployeeEditComponent},
  {path: 'employee/delete/:id', component: EmployeeEditComponent},
  {path: 'service/list', component: ServiceListComponent},
  {path: 'service/create', component: ServiceCreateComponent},
  {path: 'service/edit/:id', component: ServiceEditComponent},
  {path: 'contract/create', component: ContractCreateComponent},
  {path: 'contract/list', component: ContractListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
