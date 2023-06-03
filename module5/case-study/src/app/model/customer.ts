import {CustomerType} from './customer-type';

export interface Customer {
  idCustomer?: string;
  nameCustomer?: string;
  dateCustomer?: string;
  genderCustomer?: number;
  idCardCustomer?: number;
  phoneCustomer?: string;
  emailCustomer?: string;
  typeCustomer?: CustomerType;
  addressCustomer?: string;
}
