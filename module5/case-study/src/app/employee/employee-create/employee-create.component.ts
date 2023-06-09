import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../service/employee.service';
import {Router} from '@angular/router';
import {PositionService} from '../../service/position.service';
import {PartService} from '../../service/part.service';
import {LevelService} from '../../service/level.service';
import {Position} from '../../model/position';
import {Part} from '../../model/part';
import {Level} from '../../model/level';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  positions: Position[];
  parts: Part[];
  levels: Level[];
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

  constructor(private employeeService: EmployeeService, private router: Router,
              private positionService: PositionService, private partService: PartService,
              private levelService: LevelService) { }

  ngOnInit(): void {
    this.employeeForm = new FormGroup({
      idEmployee: new FormControl('', [Validators.required, Validators.pattern(/^NV-[0-9]{4}$/)]),
      nameEmployee: new FormControl('', [Validators.required]),
      viTriEmployee: new FormControl('', [Validators.required]),
      trinhDoEmployee: new FormControl('', [Validators.required]),
      boPhanEmployee: new FormControl('', [Validators.required]),
      dateEmployee: new FormControl('', [Validators.required]),
      idCardEmployee: new FormControl('', [Validators.required, Validators.pattern(/^[0-9]{9,10}$/)]),
      salaryEmployee: new FormControl('', [Validators.required, Validators.min(0)]),
      phoneEmployee: new FormControl('', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]),
      emailEmployee: new FormControl('', [Validators.required, Validators.email]),
      addressEmployee: new FormControl('', [Validators.required]),
    });
    this.getAllLevel();
    this.getAllPart();
    this.getAllPosition();
  }

  submit() {
    const employee = this.employeeForm.value;
    this.employeeService.saveEmployee(employee).subscribe(data => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Thêm mới thành công',
        showConfirmButton: false,
        timer: 1500
      });
      this.employeeForm.reset();
      this.router.navigateByUrl('/employee/list');
    });

  }

  reset() {
  this.employeeForm.reset();
  this.router.navigateByUrl('/employee/create');
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
