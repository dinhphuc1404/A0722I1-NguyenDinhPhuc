import { Injectable } from '@angular/core';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [{
    idCustomer: '1',
    nameCustomer: 'Phúc',
    dateCustomer: '14-04-2001',
    genderCustomer: 0,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'dinhphuc14042001@gmail.com',
    typeCustomer: 0,
    addressCustomer: 'Quảng Nam'
  }, {
    idCustomer: '2',
    nameCustomer: 'Nguyễn Văn A',
    dateCustomer: '14-04-2001',
    genderCustomer: 2,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'nguyenvana@gmail.com',
    typeCustomer: 2,
    addressCustomer: 'Đà Nẵng'
  }, {
    idCustomer: '3',
    nameCustomer: 'Nguyễn Thị B',
    dateCustomer: '14-04-2001',
    genderCustomer: 1,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'nguyenvana@gmail.com',
    typeCustomer: 1,
    addressCustomer: 'Đà Nẵng'
  }, {
    idCustomer: '4',
    nameCustomer: 'Nguyễn Văn C',
    dateCustomer: '14-04-2001',
    genderCustomer: 1,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'nguyenvana@gmail.com',
    typeCustomer: 2,
    addressCustomer: 'Đà Nẵng'
  }, {
    idCustomer: '5',
    nameCustomer: 'Nguyễn Văn A',
    dateCustomer: '14-04-2001',
    genderCustomer: 2,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'nguyenvana@gmail.com',
    typeCustomer: 2,
    addressCustomer: 'Đà Nẵng'
  }, {
    idCustomer: '6',
    nameCustomer: 'Nguyễn Văn A',
    dateCustomer: '14-04-2001',
    genderCustomer: 2,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'nguyenvana@gmail.com',
    typeCustomer: 1,
    addressCustomer: 'Đà Nẵng'
  }];
  constructor() { }

  getAll() {
    return this.customers;
  }

  saveCustomer(customer) {
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
