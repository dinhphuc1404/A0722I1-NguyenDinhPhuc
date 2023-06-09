import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../model/customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../model/customer-type';
import {CustomerTypeService} from '../../service/customer-type.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  id: number;
  customerTypes: CustomerType[];
  customerForm: FormGroup = new FormGroup({
    id: new FormControl(),
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
  constructor(private customerService: CustomerService,
              private activateRoute: ActivatedRoute, private router: Router,
              private customerTypeService: CustomerTypeService) {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });
  }

  ngOnInit(): void {
    this.customerService.findById(this.id).subscribe(customer => {
      this.customerForm = new FormGroup({
        id: new FormControl(customer.id),
        idCustomer: new FormControl(customer.idCustomer),
        nameCustomer: new FormControl(customer.nameCustomer, [Validators.required]),
        dateCustomer: new FormControl(customer.dateCustomer, [Validators.required]),
        genderCustomer: new FormControl(customer.genderCustomer, [Validators.required]),
        idCardCustomer: new FormControl(customer.idCardCustomer, [Validators.required, Validators.pattern(/^[0-9]{9,10}$/)]),
        phoneCustomer: new FormControl(customer.phoneCustomer, [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]),
        emailCustomer: new FormControl(customer.emailCustomer, [Validators.required, Validators.email]),
        typeCustomer: new FormControl(customer.typeCustomer.id, [Validators.required]),
        addressCustomer: new FormControl(customer.addressCustomer, [Validators.required])
      });
    });
    this.getAllCustomerType();
  }



  updateCustomer(id: number) {
    const customer = this.customerForm.value;
    this.customerTypeService.findById(customer.typeCustomer).subscribe(data => {
      customer.typeCustomer = data;
      this.customerService.updateCustomer(id, customer).subscribe(() => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Update thành công',
          showConfirmButton: false,
          timer: 1500
        });
        this.router.navigateByUrl('/customer/list');
      });
    });
  }
  getAllCustomerType() {
    this.customerTypeService.getAllType().subscribe(data => {
      this.customerTypes = data;
    });
  }
}
