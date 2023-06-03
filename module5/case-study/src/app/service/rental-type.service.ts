import { Injectable } from '@angular/core';
import {RentalType} from '../model/rentalType';

@Injectable({
  providedIn: 'root'
})
export class RentalTypeService {
  rentalTypes: RentalType[] = [{
    idRentalType: 1,
    nameRentalType: 'Ngày',
    cost: 1000000
  }, {
    idRentalType: 2,
    nameRentalType: 'Tháng',
    cost: 10000000
  }, {
    idRentalType: 1,
    nameRentalType: 'Năm',
    cost: 100000000
  }];
  constructor() { }
  getAllRentalType() {
    return this.rentalTypes;
  }
}
