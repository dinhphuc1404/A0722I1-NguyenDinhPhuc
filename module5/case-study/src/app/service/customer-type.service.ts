import { Injectable } from '@angular/core';
import {CustomerType} from '../model/customer-type';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  customerTypes: CustomerType[] = [{
    idCustomerType: '1',
    nameCustomerType: 'Diamond'
  }, {
    idCustomerType: '2',
    nameCustomerType: 'Platinium'
  }, {
    idCustomerType: '3',
    nameCustomerType: 'Gold'
  }, {
    idCustomerType: '4',
    nameCustomerType: 'Silver'
  }, {
    idCustomerType: '5',
    nameCustomerType: 'Member'
  }];
  constructor() { }
  getAllType() {
    return this.customerTypes;
  }
  findById(id: string) {
    return this.customerTypes.find(customerType => customerType.idCustomerType === id);
  }
}
