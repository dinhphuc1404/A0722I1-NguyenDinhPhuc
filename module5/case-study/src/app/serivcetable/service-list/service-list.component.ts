import { Component, OnInit } from '@angular/core';
import {Service} from '../../model/service';
import {ServiceService} from '../../service/service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  services: Service[];
  service: Service;
  p = 1;
  mgs = false;
  constructor(private serviceService: ServiceService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getALl();
  }
  getALl() {
    this.serviceService.getAll().subscribe(data => {
      this.services = data;
    });
  }

  getService(id: number) {
    this.serviceService.findById(id).subscribe(data => {
      this.service = data;
    });
  }

  delete() {
    this.serviceService.deleteService(this.service.id).subscribe(() => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Xóa thành công',
        showConfirmButton: false,
        timer: 1500
      });
      this.getALl();
    });
  }
}
