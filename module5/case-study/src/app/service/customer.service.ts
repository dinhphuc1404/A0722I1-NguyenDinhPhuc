import { Injectable } from '@angular/core';
import {Customer} from '../model/customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [{
    idCustomer: 'KH-1111',
    nameCustomer: 'Nguyễn Đình Phúc',
    dateCustomer: '2001/04/14',
    genderCustomer: 0,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'dinhphuc14042001@gmail.com',
    typeCustomer: {
      idCustomerType: '1',
      nameCustomerType: 'Diamond'
    },
    addressCustomer: 'Quảng Nam'
  }, {
    idCustomer: 'KH-1112',
    nameCustomer: 'Nguyễn Văn A',
    dateCustomer: '2001/04/14',
    genderCustomer: 0,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'abc@gmail.com',
    typeCustomer: {
      idCustomerType: '2',
      nameCustomerType: 'Platinium'
    },
    addressCustomer: 'Đà Nẵng'
  }, {
    idCustomer: 'KH-1113',
    nameCustomer: 'Nguyễn Thị B',
    dateCustomer: '2001/04/14',
    genderCustomer: 1,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'thib@gmail.com',
    typeCustomer: {
      idCustomerType: '3',
      nameCustomerType: 'Gold'
    },
    addressCustomer: 'Hà Nội'
  }, {
    idCustomer: 'KH-1114',
    nameCustomer: 'Nguyễn Văn D',
    dateCustomer: '2001/04/14',
    genderCustomer: 2,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'vand@gmail.com',
    typeCustomer: {
      idCustomerType: '4',
      nameCustomerType: 'Silver'
    },
    addressCustomer: 'Quảng Bình'
  }, {
    idCustomer: 'KH-1115',
    nameCustomer: 'Võ H',
    dateCustomer: '2001/04/14',
    genderCustomer: 0,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'h@gmail.com',
    typeCustomer: {
      idCustomerType: '5',
      nameCustomerType: 'Member'
    },
    addressCustomer: 'Lào cai'
  }];
  constructor() { }

  getAll() {
    return this.customers;
  }

  saveCustomer(customer: Customer) {
   this.customers.push(customer);
  }

  findById(id: string) {
    return this.customers.find(customer => customer.idCustomer === id);
  }

  updateCustomer(id: string, customer: Customer) {
    for (let i = 0; i < this.customers.length; i++) {
      if (this.customers[i].idCustomer === id) {
        this.customers[i] = customer;
      }
    }
  }

  deleteCustomer(id: string) {
    this.customers = this.customers.filter(customer => {
      return customer.idCustomer !== id;
    });
  }
}
