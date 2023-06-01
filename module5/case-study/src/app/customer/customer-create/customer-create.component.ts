import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerForm: FormGroup = new FormGroup({
    idCustomer: new FormControl(),
    nameCustomer: new FormControl(),
    dateCustomer:  new FormControl(),
    genderCustomer: new FormControl(),
    idCardCustomer:  new FormControl(),
    phoneCustomer: new FormControl(),
    emailCustomer:  new FormControl(),
    typeCustomer: new FormControl(),
    addressCustomer:  new FormControl(),
  });

  constructor(private customerService: CustomerService, private router: Router) { }

  ngOnInit(): void {
    this.customerForm = new FormGroup({
      idCustomer: new FormControl('', [Validators.required, Validators.pattern(/^KH-[0-9]{4}$/)]),
      nameCustomer: new FormControl('', [Validators.required]),
      dateCustomer: new FormControl('', [Validators.required]),
      genderCustomer: new FormControl('', [Validators.required]),
      idCardCustomer: new FormControl('', [Validators.required, Validators.pattern(/^[0-9]{9,10}$/)]),
      phoneCustomer: new FormControl('', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]),
      emailCustomer: new FormControl('', [Validators.required, Validators.email]),
      typeCustomer: new FormControl('', [Validators.required]),
      addressCustomer: new FormControl('', [Validators.required])
    });
  }
  submit() {
    const customer = this.customerForm.value;
    this.customerService.saveCustomer(customer);
    this.customerForm.reset();
    this.router.navigateByUrl('customer/list');
  }

  reset() {
    this.customerForm.reset();
    this.router.navigateByUrl('customer/create');
  }
}
