import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RentalType} from '../../model/rentalType';
import {ServiceService} from '../../service/service.service';
import {RentalTypeService} from '../../service/rental-type.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-service-edit',
  templateUrl: './service-edit.component.html',
  styleUrls: ['./service-edit.component.css']
})
export class ServiceEditComponent implements OnInit {
  serviceForm: FormGroup = new FormGroup({
    id: new FormControl(),
    idService: new FormControl(),
    nameService: new FormControl(),
    dienTichService: new FormControl(),
    soTangService: new FormControl(),
    soNguoiToiDa: new FormControl(),
    chiPhiThue: new FormControl(),
    rentalType: new FormControl(),
    trangThai: new FormControl()
  });
  id: number;
  rentalTypes: RentalType[];
  constructor(private serviceService: ServiceService, private rentalTypeService: RentalTypeService,
              private router: Router, private activateRoute: ActivatedRoute) {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });
  }

  ngOnInit(): void {
    this.serviceService.findById(this.id).subscribe(service => {
      this.serviceForm = new FormGroup({
        id: new FormControl(service.id),
        idService: new FormControl(service.idService, [Validators.required, Validators.pattern(/^DV-[0-9]{4}$/)]),
        nameService: new FormControl(service.nameService, [Validators.required]),
        dienTichService: new FormControl(service.dienTichService, [Validators.required, Validators.min(0)]),
        soTangService: new FormControl(service.soTangService, [Validators.required, Validators.min(0)]),
        soNguoiToiDa: new FormControl(service.soNguoiToiDa, [Validators.required, Validators.min(0)]),
        chiPhiThue: new FormControl(service.chiPhiThue, [Validators.required, Validators.min(0)]),
        rentalType: new FormControl(service.rentalType.id, [Validators.required]),
        trangThai: new FormControl(service.trangThai, [Validators.required])
      });
    });
    this.getAllRentalType();
  }
  getAllRentalType() {
    this.rentalTypeService.getAllRentalType().subscribe(data => {
      this.rentalTypes = data;
    });
  }

  reset() {
  }

  update(id: number) {
    const service = this.serviceForm.value;
    this.rentalTypeService.findById(service.rentalType).subscribe(next => {
      service.rentalType = next;
      this.serviceService.updateService(id, service).subscribe(() => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Update thành công',
          showConfirmButton: false,
          timer: 1500
        });
        this.router.navigateByUrl('/service/list');
      });
    });
  }
}
