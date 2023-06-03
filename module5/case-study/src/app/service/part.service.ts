import { Injectable } from '@angular/core';
import {Part} from '../model/part';

@Injectable({
  providedIn: 'root'
})
export class PartService {
  parts: Part[] = [{
    idPart: 1,
    namePart: 'Sale – Marketing'
  }, {
    idPart: 2,
    namePart: 'Hành chính'
  }, {
    idPart: 3,
    namePart: 'Phục vụ'
  }, {
    idPart: 4,
    namePart: 'Quản lý'
  }];
  constructor() { }
  getAllPart() {
    return this.parts;
  }

  findById(id: number) {
    return this.parts.find(part => part.idPart === id);
  }
}
