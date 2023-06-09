import { Component, OnInit } from '@angular/core';
import {Employee} from '../../model/employee';
import {EmployeeService} from '../../service/employee.service';
import {Position} from '../../model/position';
import {Part} from '../../model/part';
import {Level} from '../../model/level';
import {PositionService} from '../../service/position.service';
import {PartService} from '../../service/part.service';
import {LevelService} from '../../service/level.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = [];
  employee: Employee;
  p = 1;
  constructor(private employeeService: EmployeeService,
              private positionService: PositionService, private partService: PartService,
              private levelService: LevelService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.employeeService.getAll().subscribe(data => {
      this.employees = data;
    });
  }



  getEmployee(id: number) {
    this.employeeService.findById(id).subscribe(data => {
      this.employee = data;
    });
  }

  delete() {
    this.employeeService.deleteEmployee(this.employee.id).subscribe(() => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Xóa thành công',
        showConfirmButton: false,
        timer: 1500
      });
      this.getAll();
    });
  }
}
