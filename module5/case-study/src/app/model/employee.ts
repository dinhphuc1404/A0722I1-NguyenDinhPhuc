import {Level} from './level';
import {Position} from './position';
import {Part} from './part';

export interface Employee {
  id?: number;
  idEmployee?: string;
  nameEmployee?: string;
  viTriEmployee?: Position;
  trinhDoEmployee?: Level;
  boPhanEmployee?: Part;
  dateEmployee?: string;
  idCardEmployee?: number;
  salaryEmployee?: number;
  phoneEmployee?: string;
  emailEmployee?: string;
  addressEmployee?: string;
}
