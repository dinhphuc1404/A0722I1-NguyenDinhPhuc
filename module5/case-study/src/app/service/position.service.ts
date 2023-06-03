import { Injectable } from '@angular/core';
import {Position} from '../model/position';

@Injectable({
  providedIn: 'root'
})
export class PositionService {
  position: Position[] = [{
    idPosition: 1,
    namePositon: 'Lễ tân',
  }, {
    idPosition: 2,
    namePositon: 'Phục vụ',
  }, {
    idPosition: 3,
    namePositon: 'Chuyên viên',
  }, {
    idPosition: 4,
    namePositon: 'Giám sát',
  }, {
    idPosition: 5,
    namePositon: 'Quản lý',
  }, {
    idPosition: 6,
    namePositon: 'Giám đốc',
  }];
  constructor() { }
  getAllPosition() {
    return this.position;
  }

  findById(id: number) {
    return this.position.find(position => position.idPosition === id);
  }
}
