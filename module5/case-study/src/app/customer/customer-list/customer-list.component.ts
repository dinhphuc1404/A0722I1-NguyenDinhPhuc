import { Component, OnInit } from '@angular/core';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import {Router, ActivatedRoute} from '@angular/router';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
  customer: Customer;
  p = 1;
   mgs = false;
  constructor(private customerSerivice: CustomerService ,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.customerSerivice.getAll().subscribe(data => {
      this.customers = data;
    });
  }


  getCustomer(id: number) {
    this.customerSerivice.findById(id).subscribe(data => {
      this.customer = data;
    });
  }

  delete() {
    this.customerSerivice.deleteCustomer(this.customer.id).subscribe(() => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Xóa thành công',
        showConfirmButton: false,
        timer: 1500
      });
      this.getAll();
    });
  }

  search(inputSerach: HTMLInputElement) {
    if (inputSerach.value === '') {
      Swal.fire('Vui lòng nhập từ khóa cần tìm kiếm');
    } else {
      this.customerSerivice.search(inputSerach.value).subscribe(next => {
        this.customers = next;
        if (this.customers.length === 0) {
          this.mgs = true;
        } else {
          this.mgs = false;
        }
      });
    }
  }
}
