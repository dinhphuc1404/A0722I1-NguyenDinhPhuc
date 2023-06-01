import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../model/customer';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  id: string;
  customerForm: FormGroup;
  constructor(private customerService: CustomerService,
              private activateRoute: ActivatedRoute, private router: Router) {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
      const customer: Customer = this.getCustomer(this.id);
      this.customerForm = new FormGroup({
        idCustomer: new FormControl(customer.idCustomer),
        nameCustomer: new FormControl(customer.nameCustomer),
        dateCustomer:  new FormControl(customer.dateCustomer),
        genderCustomer: new FormControl(customer.genderCustomer),
        idCardCustomer:  new FormControl(customer.idCardCustomer),
        phoneCustomer: new FormControl(customer.phoneCustomer),
        emailCustomer:  new FormControl(customer.emailCustomer),
        typeCustomer: new FormControl(customer.typeCustomer),
        addressCustomer:  new FormControl(customer.addressCustomer),
      });
    });
  }

  ngOnInit(): void {
  }

  getCustomer(id: string) {
    return this.customerService.findById(id);
  }

  updateCustomer(id: string) {
    const customer = this.customerForm.value;
    this.customerService.updateCustomer(id, customer);
    this.router.navigateByUrl('/customer/list');
  }

  reset() {
    this.customerForm.reset();
    this.router.navigateByUrl('customer/edit');
  }
}
