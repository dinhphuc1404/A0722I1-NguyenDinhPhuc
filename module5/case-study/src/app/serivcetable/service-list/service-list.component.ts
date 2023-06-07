import { Component, OnInit } from '@angular/core';
import {Service} from '../../model/service';
import {ServiceService} from '../../service/service.service';
import {RentalType} from '../../model/rentalType';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {RentalTypeService} from '../../service/rental-type.service';
import {FormControl, FormGroup} from '@angular/forms';


@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  services: Service[] = [];
  id: string;
  rentalType: RentalType[] = [];
  service: Service;
  serviceForm: FormGroup;
  constructor(private serviceService: ServiceService, private rentalTypeService: RentalTypeService,
              private router: Router, private activateRoute: ActivatedRoute) {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
    });
  }

  ngOnInit(): void {
    // const service: Service = this.getService(this.id);
    // this.serviceForm = new FormGroup({
    //   idService: new FormControl(service?.idService),
    //   nameService: new FormControl(service?.nameService),
    //   dienTichService: new FormControl(service?.dienTichService),
    //   soTangService: new FormControl(service?.soTangService),
    //   soNguoiToiDa: new FormControl(service?.soNguoiToiDa),
    //   chiPhiThue: new FormControl(service?.chiPhiThue),
    //   rentalType: new FormControl(service?.rentalType.idRentalType),
    //   trangThai: new FormControl(service?.trangThai)
    // });
    this.getAllRentalType();
    this.getALl();
  }
  getALl() {
    this.services = this.serviceService.getAll();
  }

  update(id: string) {
    const service = this.serviceForm.value;
    service.rentalType = this.rentalTypeService.findById(+service.rentalType);
    this.serviceService.updateService(id, service);
    this.router.navigateByUrl('/service/list');
  }

  private getAllRentalType() {
    this.rentalType = this.rentalTypeService.getAllRentalType();
  }

  getService(id: string) {
    this.service = this.serviceService.findById(id);
    this.serviceForm = new FormGroup({
      idService: new FormControl(this.service?.idService),
      nameService: new FormControl(this.service?.nameService),
      dienTichService: new FormControl(this.service?.dienTichService),
      soTangService: new FormControl(this.service?.soTangService),
      soNguoiToiDa: new FormControl(this.service?.soNguoiToiDa),
      chiPhiThue: new FormControl(this.service?.chiPhiThue),
      rentalType: new FormControl(this.service?.rentalType.idRentalType),
      trangThai: new FormControl(this.service?.trangThai)
    });
  }
}
