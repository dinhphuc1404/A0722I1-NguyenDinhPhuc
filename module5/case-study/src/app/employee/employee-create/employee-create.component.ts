import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../service/employee.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
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

  constructor(private employeeService: EmployeeService, private router: Router) { }

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
  }

  submit() {
    const employee = this.employeeForm.value;
    this.employeeService.saveEmployee(employee);
    this.employeeForm.reset();
    this.router.navigateByUrl('/employee/list');
  }

  reset() {
  this.employeeForm.reset();
  this.router.navigateByUrl('/employee/create');
  }
}
