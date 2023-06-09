import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Employee} from '../../model/employee';
import {Customer} from '../../model/customer';
import {Service} from '../../model/service';
import {ContractService} from '../../service/contract.service';
import {EmployeeService} from '../../service/employee.service';
import {CustomerService} from '../../service/customer.service';
import {ServiceService} from '../../service/service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
  contractForm: FormGroup = new FormGroup({
    code: new FormControl(),
    employee: new FormControl(),
    customer: new FormControl(),
    service: new FormControl(),
    ngayLamHopDong: new FormControl(),
    ngayKetThuc: new FormControl(),
    tienDatCoc: new FormControl(),
    tongTien: new FormControl(),
  });
  employees: Employee[];
  customers: Customer[];
  services: Service[];

  constructor(private contractService: ContractService, private employeeService: EmployeeService,
              private customerService: CustomerService, private serviceService: ServiceService,
              private router: Router) { }

  ngOnInit(): void {
    this.contractForm = new FormGroup({
      code: new FormControl('', [Validators.required]),
      employee: new FormControl('', [Validators.required]),
      customer: new FormControl('', [Validators.required]),
      service: new FormControl('', [Validators.required]),
      ngayLamHopDong: new FormControl('', [Validators.required]),
      ngayKetThuc: new FormControl('', [Validators.required]),
      tienDatCoc: new FormControl('', [Validators.required, Validators.min(0)]),
      tongTien: new FormControl('', [Validators.required, Validators.min(0)]),
    });
    this.getAllCustomer();
    this.getAllEmployee();
    this.getAllService();
  }

  submit() {
    const contract = this.contractForm.value;
    this.contractService.save(contract).subscribe(() => {
    this.router.navigateByUrl('/contract/list');
    });
  }

  reset() {
  }

  getAllEmployee() {
    this.employeeService.getAll().subscribe(data => {
      this.employees = data;
    });
  }
  getAllCustomer() {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
    });
  }
  getAllService() {
    this.serviceService.getAll().subscribe(data => {
      this.services = data;
    });
  }
}
