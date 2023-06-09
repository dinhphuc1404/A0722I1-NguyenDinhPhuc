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
import Swal from 'sweetalert2';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  employeeForm: FormGroup = new FormGroup({
    idEmployee: new FormControl(),
    nameEmployee: new FormControl(),
    viTriEmployee: new FormControl(),
    trinhDoEmployee: new FormControl(),
    boPhanEmployee: new FormControl(),
    dateEmployee: new FormControl(),
    idCardEmployee: new FormControl(),
    salaryEmployee: new FormControl(),
    phoneEmployee: new FormControl(),
    emailEmployee: new FormControl(),
    addressEmployee: new FormControl(),
  });
  id: number;
  positions: Position[] = [];
  parts: Part[] = [];
  levels: Level[] = [];
  constructor(private emloyeeService: EmployeeService,
              private router: Router, private activateRoute: ActivatedRoute,
              private positionService: PositionService, private partService: PartService,
              private levelService: LevelService) {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });
  }

  ngOnInit(): void {
    this.emloyeeService.findById(this.id).subscribe(employee => {
      this.employeeForm = new FormGroup({
        idEmployee: new FormControl(employee.idEmployee, [Validators.required]),
        nameEmployee: new FormControl(employee.nameEmployee, [Validators.required]),
        viTriEmployee: new FormControl(employee.viTriEmployee.id, [Validators.required]),
        trinhDoEmployee: new FormControl(employee.trinhDoEmployee.id, [Validators.required]),
        boPhanEmployee: new FormControl(employee.boPhanEmployee.id, [Validators.required]),
        dateEmployee: new FormControl(employee.dateEmployee, [Validators.required]),
        idCardEmployee: new FormControl(employee.idCardEmployee, [Validators.required, Validators.pattern(/^[0-9]{9,10}$/)]),
        salaryEmployee: new FormControl(employee.salaryEmployee, [Validators.required, Validators.min(0)]),
        phoneEmployee: new FormControl(employee.phoneEmployee, [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]),
        emailEmployee: new FormControl(employee.emailEmployee, [Validators.required, Validators.email]),
        addressEmployee: new FormControl(employee.addressEmployee, [Validators.required]),
      });
    });
    this.getAllLevel();
    this.getAllPosition();
    this.getAllPart();
  }

  updateemployee(id: number) {
    const employee = this.employeeForm.value;
    this.positionService.findById(employee.viTriEmployee).subscribe(data => {
      employee.viTriEmployee = data;
      this.partService.findById(employee.boPhanEmployee).subscribe(data1 => {
      employee.boPhanEmployee = data1;
      this.levelService.findById(employee.trinhDoEmployee).subscribe(data3 => {
          employee.trinhDoEmployee = data3;
          this.emloyeeService.updateEmployee(id, employee).subscribe(() => {
            Swal.fire({
              position: 'top-end',
              icon: 'success',
              title: 'Update thành công',
              showConfirmButton: false,
              timer: 1500
            });
            this.router.navigateByUrl('/employee/list');
          });
        });
    });
    });
  }
  getAllPosition() {
    this.positionService.getAllPosition().subscribe(data => {
      this.positions = data;
    });
  }
  getAllPart() {
    this.partService.getAllPart().subscribe(data => {
      this.parts = data;
    });
  }
  getAllLevel() {
    this.levelService.getAllLevel().subscribe(data => {
      this.levels = data;
    });
  }
}
