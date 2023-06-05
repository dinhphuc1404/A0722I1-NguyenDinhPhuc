import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {RentalType} from '../../model/rentalType';
import {FormControl, FormGroup} from '@angular/forms';
import {ServiceService} from '../../service/service.service';
import {RentalTypeService} from '../../service/rental-type.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {
  // @ViewChild('modelId') modelId: ElementRef;
  rentalTypes: RentalType[] = [];
  serviceForm: FormGroup;
  constructor(private serviceService: ServiceService,
              private rentalTypeService: RentalTypeService,
              private router: Router) { }

  ngOnInit(): void {
    this.serviceForm = new FormGroup({
      idService: new FormControl(),
      nameService: new FormControl(),
      dienTichService: new FormControl(),
      soTangService: new FormControl(),
      soNguoiToiDa: new FormControl(),
      chiPhiThue: new FormControl(),
      rentalType: new FormControl(),
      trangThai: new FormControl()
    });
    this.getAllRentalType();
  }

  submit() {
    const service = this.serviceForm.value;
    service.rentalType = this.rentalTypeService.findById(+service.rentalType);
    this.serviceService.saveService(service);
    this.serviceForm.reset();
    // this.modelId?.nativeElement.hide();
    this.router.navigateByUrl('/service/list');
  }
  getAllRentalType() {
    this.rentalTypes = this.rentalTypeService.getAllRentalType();
  }
}
