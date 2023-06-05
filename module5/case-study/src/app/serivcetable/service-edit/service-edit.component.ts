import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {RentalType} from '../../model/rentalType';
import {ServiceService} from '../../service/service.service';
import {RentalTypeService} from '../../service/rental-type.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Service} from '../../model/service';

@Component({
  selector: 'app-service-edit',
  templateUrl: './service-edit.component.html',
  styleUrls: ['./service-edit.component.css']
})
export class ServiceEditComponent implements OnInit {
  serviceForm: FormGroup;
  id: string;
  rentalType: RentalType[] = [];
  constructor(private serviceService: ServiceService, private rentalTypeService: RentalTypeService,
              private router: Router, private activateRoute: ActivatedRoute) {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
    });
  }

  ngOnInit(): void {
    const service: Service = this.getService(this.id);
    this.serviceForm = new FormGroup({
      idService: new FormControl(service?.idService),
      nameService: new FormControl(service?.nameService),
      dienTichService: new FormControl(service?.dienTichService),
      soTangService: new FormControl(service?.soTangService),
      soNguoiToiDa: new FormControl(service?.soNguoiToiDa),
      chiPhiThue: new FormControl(service?.chiPhiThue),
      rentalType: new FormControl(service?.rentalType.idRentalType),
      trangThai: new FormControl(service?.trangThai)
    });
    this.getAllRentalType();
  }
  getService(id: string) {
    return this.serviceService.findById(id);
  }

  updateService(id: string) {
    const service = this.serviceForm.value;
    service.rentalType = this.rentalTypeService.findById(+service.rentalType);
    this.serviceService.updateService(id, service);
    this.router.navigateByUrl('/service/list');
  }
  getAllRentalType() {
    this.rentalType = this.rentalTypeService.getAllRentalType();
  }
}
