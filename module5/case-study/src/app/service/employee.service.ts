import { Injectable } from '@angular/core';
import {Employee} from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  // @ts-ignore
  // @ts-ignore
  employees: Employee [] = [{
    idEmployee: '1',
    nameEmployee: 'Nguyễn Đình Phúc',
    viTriEmployee: 5,
    trinhDoEmployee: 0,
    boPhanEmployee: 2,
    dateEmployee: '14/04/2001',
    idCardEmployee: 206306357,
    salaryEmployee: 5000000,
    phoneEmployee: '+84936558748',
    emailEmployee: 'phuc@gmail.com',
    addressEmployee: 'Quảng Nam',
  }, {
    idEmployee: '2',
    nameEmployee: 'Nguyễn A',
    viTriEmployee: 4,
    trinhDoEmployee: 0,
    boPhanEmployee: 1,
    dateEmployee: '05/05/2003',
    idCardEmployee: 206306357,
    salaryEmployee: 15000000,
    phoneEmployee: '+84936558748',
    emailEmployee: 'a@gmail.com',
    addressEmployee: 'Quảng Bình',
  }, {
    idEmployee: '3',
    nameEmployee: 'Nguyễn Thị B',
    viTriEmployee: 5,
    trinhDoEmployee: 0,
    boPhanEmployee: 2,
    dateEmployee: '14/04/2001',
    idCardEmployee: 206306357,
    salaryEmployee: 5000000,
    phoneEmployee: '+84936558748',
    emailEmployee: 'b@gmail.com',
    addressEmployee: 'Đà Nẵng',
  }, {
    idEmployee: '4',
    nameEmployee: 'Nguyễn Văn C',
    viTriEmployee: 5,
    trinhDoEmployee: 0,
    boPhanEmployee: 2,
    dateEmployee: '14/04/2001',
    idCardEmployee: 206306357,
    salaryEmployee: 5000000,
    phoneEmployee: '+84936558748',
    emailEmployee: 'phuc@gmail.com',
    addressEmployee: 'Hà Nội',
  }, {
    idEmployee: '5',
    nameEmployee: 'Nguyễn D',
    viTriEmployee: 5,
    trinhDoEmployee: 0,
    boPhanEmployee: 2,
    dateEmployee: '14/04/2001',
    idCardEmployee: 206306357,
    salaryEmployee: 5000000,
    phoneEmployee: '+84936558748',
    emailEmployee: 'phuc@gmail.com',
    addressEmployee: 'Quảng Nam',
  }];

  constructor() { }

  getAll() {
    return this.employees;
  }

  saveEmployee(employee) {
    this.employees.push(employee);
  }
}
