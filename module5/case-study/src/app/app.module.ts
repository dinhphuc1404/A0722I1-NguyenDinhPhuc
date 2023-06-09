import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ContentComponent } from './content/content.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatPaginatorModule} from '@angular/material/paginator';
import { CustomerCreateComponent } from './customer/customer-create/customer-create.component';
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { EmployeeCreateComponent } from './employee/employee-create/employee-create.component';
import { EmployeeEditComponent } from './employee/employee-edit/employee-edit.component';
import { BodyComponent } from './body/body.component';
import { ServiceListComponent } from './serivcetable/service-list/service-list.component';
import { CustomerTypeListComponent } from './customer-type/customer-type-list/customer-type-list.component';
import { ServiceCreateComponent } from './serivcetable/service-create/service-create.component';
import { ServiceEditComponent } from './serivcetable/service-edit/service-edit.component';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import { ContractCreateComponent } from './contract/contract-create/contract-create.component';
import { ContractListComponent } from './contract/contract-list/contract-list.component';






@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ContentComponent,
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerEditComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeEditComponent,
    BodyComponent,
    ServiceListComponent,
    CustomerTypeListComponent,
    ServiceCreateComponent,
    ServiceEditComponent,
    ContractCreateComponent,
    ContractListComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,
        MatPaginatorModule,
        HttpClientModule,
        NgxPaginationModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
