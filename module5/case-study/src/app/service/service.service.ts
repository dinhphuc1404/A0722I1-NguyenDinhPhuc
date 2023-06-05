import { Injectable } from '@angular/core';
import {Service} from '../model/service';
import {RentalType} from '../model/rentalType';
import {RentalTypeService} from './rental-type.service';
import {Customer} from '../model/customer';

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
  }, {
    idService: 'DV-1236',
    nameService: 'House',
    dienTichService: 1500,
    soTangService: 3,
    soNguoiToiDa: 10,
    chiPhiThue: 5000000,
    rentalType: {
      idRentalType: 1,
      nameRentalType: 'Năm',
      cost: 500000
    },
    trangThai: 'Đã thuê'
  }, {
    idService: 'DV-1235',
    nameService: 'Room',
    dienTichService: 500,
    soTangService: 1,
    soNguoiToiDa: 5,
    chiPhiThue: 5000000,
    rentalType: {
      idRentalType: 1,
      nameRentalType: 'Tháng',
      cost: 50000
    },
    trangThai: 'Đã đặt'
  }];
  constructor() { }
  getAll() {
    return this.services;
  }
  saveService(service) {
    this.services.push(service);
  }

  findById(id: string) {
    return this.services.find(service => service.idService === id);
  }

  updateService(id: string, service: Service) {
    for (let i = 0; i < this.services.length; i++) {
      if (this.services[i].idService === id) {
        this.services[i] = service;
      }
    }
  }
}
