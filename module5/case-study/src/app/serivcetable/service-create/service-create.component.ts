import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {RentalType} from '../../model/rentalType';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ServiceService} from '../../service/service.service';
import {RentalTypeService} from '../../service/rental-type.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {
  rentalTypes: RentalType[] = [];
  serviceForm: FormGroup = new FormGroup({
    idService: new FormControl(),
    nameService: new FormControl(),
    dienTichService: new FormControl(),
    soTangService: new FormControl(),
    soNguoiToiDa: new FormControl(),
    chiPhiThue: new FormControl(),
    rentalType: new FormControl(),
    trangThai: new FormControl()
  });
  constructor(private serviceService: ServiceService,
              private rentalTypeService: RentalTypeService,
              private router: Router) { }

  ngOnInit(): void {
    this.serviceForm = new FormGroup({
      idService: new FormControl('', [Validators.required, Validators.pattern(/^DV-[0-9]{4}$/)]),
      nameService: new FormControl('', [Validators.required]),
      dienTichService: new FormControl('', [Validators.required, Validators.min(0)]),
      soTangService: new FormControl('', [Validators.required, Validators.min(0)]),
      soNguoiToiDa: new FormControl('', [Validators.required, Validators.min(0)]),
      chiPhiThue: new FormControl('', [Validators.required, Validators.min(0)]),
      rentalType: new FormControl('', [Validators.required]),
      trangThai: new FormControl('', [Validators.required])
    });
    this.getAllRentalType();
  }

  submit() {
    const service = this.serviceForm.value;
    this.serviceService.saveService(service).subscribe(() => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Thêm mới thành công',
        showConfirmButton: false,
        timer: 1500
      });
      this.serviceForm.reset();
      this.router.navigateByUrl('/service/list');
    });
  }
  getAllRentalType() {
    this.rentalTypeService.getAllRentalType().subscribe(data => {
      this.rentalTypes = data;
    });
  }

  reset() {
  }
}
