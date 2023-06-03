import { Injectable } from '@angular/core';
import {Level} from '../model/level';

@Injectable({
  providedIn: 'root'
})
export class LevelService {
  levels: Level[] = [{
    idLevel: 1,
    nameLevel: 'Trung cấp',
  }, {
    idLevel: 2,
    nameLevel: 'Cao đẳng'
  }, {
    idLevel: 3,
    nameLevel: 'Đại học'
  }, {
    idLevel: 4,
    nameLevel: 'Sau đại học'
  }];
  constructor() { }
  getAllLevel() {
    return this.levels;
  }
  findById(id: number) {
    return this.levels.find(level => level.idLevel === id);
  }
}
