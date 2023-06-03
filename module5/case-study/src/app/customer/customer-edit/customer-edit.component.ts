import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../model/customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../model/customer-type';
import {CustomerTypeService} from '../../service/customer-type.service';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  id: string;
  customerTypes: CustomerType[] = [];
  customerForm: FormGroup;
  constructor(private customerService: CustomerService,
              private activateRoute: ActivatedRoute, private router: Router,
              private customerTypeService: CustomerTypeService) {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
    });
  }

  ngOnInit(): void {
    const customer: Customer = this.getCustomer(this.id);
    this.customerForm = new FormGroup({
      idCustomer: new FormControl(customer.idCustomer),
      nameCustomer: new FormControl(customer.nameCustomer, [Validators.required]),
      dateCustomer: new FormControl(customer.dateCustomer, [Validators.required]),
      genderCustomer: new FormControl(customer.genderCustomer, [Validators.required]),
      idCardCustomer: new FormControl(customer.idCardCustomer, [Validators.required, Validators.pattern(/^[0-9]{9,10}$/)]),
      phoneCustomer: new FormControl(customer.phoneCustomer, [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]),
      emailCustomer: new FormControl(customer.emailCustomer, [Validators.required, Validators.email]),
      typeCustomer: new FormControl(customer.typeCustomer.idCustomerType, [Validators.required]),
      addressCustomer: new FormControl(customer.addressCustomer, [Validators.required])
    });
    this.getAll();
  }

  getCustomer(id: string) {
    return this.customerService.findById(id);
  }

  updateCustomer(id: string) {
    const customer = this.customerForm.value;
    customer.typeCustomer = this.customerTypeService.findById(customer.typeCustomer);
    this.customerService.updateCustomer(id, customer);
    this.router.navigateByUrl('/customer/list');
  }
  getAll() {
    this.customerTypes = this.customerTypeService.getAllType();
  }
}
