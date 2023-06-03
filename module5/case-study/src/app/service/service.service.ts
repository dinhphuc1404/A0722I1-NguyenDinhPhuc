import { Injectable } from '@angular/core';
import {Service} from '../model/service';
import {RentalType} from '../model/rentalType';
import {RentalTypeService} from './rental-type.service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  services: Service[] = [{
    idService: 'DV-1234',
    nameService: 'Villa',
    dienTichService: 500,
    soTangService: 2,
    soNguoiToiDa: 10,
    chiPhiThue: 5000000,
    rentalType: {
      idRentalType: 1,
      nameRentalType: 'Ngày',
      cost: 50000
    },
    trangThai: 'Đã thuê'
  }];
  constructor() { }
  getAll() {
    return this.services;
  }
}
