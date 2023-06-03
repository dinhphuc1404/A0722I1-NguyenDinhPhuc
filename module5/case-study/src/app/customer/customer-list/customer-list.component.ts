import { Component, OnInit } from '@angular/core';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import {Router, ActivatedRoute} from '@angular/router';



@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
  customer: Customer;
  constructor(private customerSerivice: CustomerService ,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.customers = this.customerSerivice.getAll();
  }


  getCustomer(idCustomer: string) {
    this.customer = this.customerSerivice.findById(idCustomer);
  }

  delete() {
    this.customer = this.customerSerivice.findById(this.customer.idCustomer);
    this.customerSerivice.deleteCustomer(this.customer.idCustomer);
    this.customers = this.customerSerivice.getAll();
  }
}
