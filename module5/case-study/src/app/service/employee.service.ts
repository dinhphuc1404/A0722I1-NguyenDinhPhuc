import { Injectable } from '@angular/core';
import {Employee} from '../model/employee';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  employees: Employee [] = [{
    idEmployee: '1',
    nameEmployee: 'Nguyễn Đình Phúc',
    viTriEmployee: {
      idPosition: 1,
      namePositon: 'Lễ tân'
    },
    trinhDoEmployee: {
      idLevel: 2,
      nameLevel: 'Cao đẳng'
    },
    boPhanEmployee: {
      idPart: 1,
      namePart: 'Sale – Marketing'
    },
    dateEmployee: '2001-04-14',
    idCardEmployee: 206306357,
    salaryEmployee: 5000000,
    phoneEmployee: '+84936558748',
    emailEmployee: 'phuc@gmail.com',
    addressEmployee: 'Quảng Nam',
  }, {
    idEmployee: '2',
    nameEmployee: 'Nguyễn A',
    viTriEmployee: {
      idPosition: 2,
      namePositon: 'Phục vụ'
    },
    trinhDoEmployee: {
      idLevel: 1,
      nameLevel: 'Trung cấp'
    },
    boPhanEmployee: {
      idPart: 2,
      namePart: 'Hành Chính'
    },
    dateEmployee: '2001-04-14',
    idCardEmployee: 206306357,
    salaryEmployee: 15000000,
    phoneEmployee: '+84936558748',
    emailEmployee: 'a@gmail.com',
    addressEmployee: 'Quảng Bình',
  }, {
    idEmployee: '3',
    nameEmployee: 'Nguyễn Thị B',
    viTriEmployee: {
      idPosition: 3,
      namePositon: 'Chuyên viên'
    },
    trinhDoEmployee: {
      idLevel: 3,
      nameLevel: 'Đại học'
    },
    boPhanEmployee: {
      idPart: 3,
      namePart: 'Phục vụ'
    },
    dateEmployee: '2001-04-14',
    idCardEmployee: 206306357,
    salaryEmployee: 5000000,
    phoneEmployee: '+84936558748',
    emailEmployee: 'b@gmail.com',
    addressEmployee: 'Đà Nẵng',
  }, {
    idEmployee: '4',
    nameEmployee: 'Nguyễn Văn C',
    viTriEmployee: {
      idPosition: 3,
      namePositon: 'Chuyên viên'
    },
    trinhDoEmployee: {
      idLevel: 3,
      nameLevel: 'Đại học'
    },
    boPhanEmployee: {
      idPart: 3,
      namePart: 'Phục vụ'
    },
    dateEmployee: '2001-04-14',
    idCardEmployee: 206306357,
    salaryEmployee: 5000000,
    phoneEmployee: '+84936558748',
    emailEmployee: 'phuc@gmail.com',
    addressEmployee: 'Hà Nội',
  }, {
    idEmployee: '5',
    nameEmployee: 'Nguyễn D',
    viTriEmployee: {
      idPosition: 3,
      namePositon: 'Chuyên viên'
    },
    trinhDoEmployee: {
      idLevel: 3,
      nameLevel: 'Đại học'
    },
    boPhanEmployee: {
      idPart: 3,
      namePart: 'Phục vụ'
    },
    dateEmployee: '2001-04-14',
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
  findById(id: string) {
    return this.employees.find(employee => employee.idEmployee === id);
  }

  updateEmployee(id: string, employee: Employee) {
    for (let i = 0; i < this.employees.length; i++) {
      if (this.employees[i].idEmployee === id) {
        this.employees[i] = employee;
      }
    }
  }

  deleteEmployee(id: string) {
    this.employees = this.employees.filter(employee => {
      return employee.idEmployee !== id;
    });
  }
}
