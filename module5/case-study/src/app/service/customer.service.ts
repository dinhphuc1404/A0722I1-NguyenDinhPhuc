import { Injectable } from '@angular/core';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [{
    idCustomer: '1',
    nameCustomer: 'Phúc',
    dateCustomer: '2001-04-14',
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
    idCustomer: '2',
    nameCustomer: 'Nguyễn Văn A',
    dateCustomer: '2001-04-14',
    genderCustomer: 2,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'nguyenvana@gmail.com',
    typeCustomer: {
      idCustomerType: '2',
      nameCustomerType: 'Platinium'
    },
    addressCustomer: 'Đà Nẵng'
  }, {
    idCustomer: '3',
    nameCustomer: 'Nguyễn Thị B',
    dateCustomer: '2001-04-14',
    genderCustomer: 1,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'nguyenvana@gmail.com',
    typeCustomer: {
      idCustomerType: '3',
      nameCustomerType: 'Gold'
    },
    addressCustomer: 'Đà Nẵng'
  }, {
    idCustomer: '4',
    nameCustomer: 'Nguyễn Văn C',
    dateCustomer: '2001-04-14',
    genderCustomer: 1,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'nguyenvana@gmail.com',
    typeCustomer: {
      idCustomerType: '4',
      nameCustomerType: 'Silver'
    },
    addressCustomer: 'Đà Nẵng'
  }, {
    idCustomer: '5',
    nameCustomer: 'Nguyễn Văn A',
    dateCustomer: '2001-04-14',
    genderCustomer: 2,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'nguyenvana@gmail.com',
    typeCustomer: {
      idCustomerType: '5',
      nameCustomerType: 'Member'
    },
    addressCustomer: 'Đà Nẵng'
  }, {
    idCustomer: '6',
    nameCustomer: 'Nguyễn Văn A',
    dateCustomer: '2001-04-14',
    genderCustomer: 2,
    idCardCustomer: 206306357,
    phoneCustomer: '+84935338475',
    emailCustomer: 'nguyenvana@gmail.com',
    typeCustomer: {
      idCustomerType: '1',
      nameCustomerType: 'Diamond'
    },
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
