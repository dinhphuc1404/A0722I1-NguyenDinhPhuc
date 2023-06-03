import { Component, OnInit } from '@angular/core';
import {Employee} from '../../model/employee';
import {EmployeeService} from '../../service/employee.service';
import {Position} from '../../model/position';
import {Part} from '../../model/part';
import {Level} from '../../model/level';
import {PositionService} from '../../service/position.service';
import {PartService} from '../../service/part.service';
import {LevelService} from '../../service/level.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = [];
  employee: Employee;
  constructor(private employeeService: EmployeeService,
              private positionService: PositionService, private partService: PartService,
              private levelService: LevelService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.employees = this.employeeService.getAll();
  }

  getEmployee(idEmployee: string) {
    this.employee = this.employeeService.findById(idEmployee);
  }

  delete() {
    this.employee = this.employeeService.findById(this.employee.idEmployee);
    this.employeeService.deleteEmployee(this.employee.idEmployee);
    this.employees = this.employeeService.getAll();
  }
}
