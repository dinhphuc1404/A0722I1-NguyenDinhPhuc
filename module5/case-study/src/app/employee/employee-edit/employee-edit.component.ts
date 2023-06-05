import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../service/employee.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {PositionService} from '../../service/position.service';
import {PartService} from '../../service/part.service';
import {LevelService} from '../../service/level.service';
import {Position} from '../../model/position';
import {Part} from '../../model/part';
import {Level} from '../../model/level';
import {Employee} from '../../model/employee';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  employeeForm: FormGroup;
  id: string;
  positions: Position[] = [];
  parts: Part[] = [];
  levels: Level[] = [];
  constructor(private emloyeeService: EmployeeService,
              private router: Router, private activateRoute: ActivatedRoute,
              private positionService: PositionService, private partService: PartService,
              private levelService: LevelService) {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
    });
  }

  ngOnInit(): void {
    const employee: Employee = this.getEmployee(this.id);
    this.employeeForm = new FormGroup({
      idEmployee: new FormControl(employee.idEmployee, [Validators.required]),
      nameEmployee: new FormControl(employee.nameEmployee, [Validators.required]),
      viTriEmployee: new FormControl(employee.viTriEmployee.idPosition, [Validators.required]),
      trinhDoEmployee: new FormControl(employee.trinhDoEmployee.idLevel, [Validators.required]),
      boPhanEmployee: new FormControl(employee.boPhanEmployee.idPart, [Validators.required]),
      dateEmployee: new FormControl(employee.dateEmployee, [Validators.required]),
      idCardEmployee: new FormControl(employee.idCardEmployee, [Validators.required, Validators.pattern(/^[0-9]{9,10}$/)]),
      salaryEmployee: new FormControl(employee.salaryEmployee, [Validators.required, Validators.min(0)]),
      phoneEmployee: new FormControl(employee.phoneEmployee, [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]),
      emailEmployee: new FormControl(employee.emailEmployee, [Validators.required, Validators.email]),
      addressEmployee: new FormControl(employee.addressEmployee, [Validators.required]),
    });
    this.getAllLevel();
    this.getAllPosition();
    this.getAllPart();
  }
  getEmployee(id: string) {
    return this.emloyeeService.findById(id);
  }
  updateemployee(id: string) {
    const employee = this.employeeForm.value;
    employee.viTriEmployee = this.positionService.findById(+employee.viTriEmployee);
    employee.trinhDoEmployee = this.levelService.findById(+employee.trinhDoEmployee);
    employee.boPhanEmployee = this.partService.findById(+employee.boPhanEmployee);
    this.emloyeeService.updateEmployee(id, employee);
    this.router.navigateByUrl('/employee/list');
  }
  getAllPosition() {
    this.positions = this.positionService.getAllPosition();
  }
  getAllPart() {
    this.parts = this.partService.getAllPart();
  }
  getAllLevel() {
    this.levels = this.levelService.getAllLevel();
  }


}
