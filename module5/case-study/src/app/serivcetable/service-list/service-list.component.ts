import { Component, OnInit } from '@angular/core';
import {Service} from '../../model/service';
import {ServiceService} from '../../service/service.service';


@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  services: Service[] = [];
  constructor(private serviceService: ServiceService) { }

  ngOnInit(): void {
    this.getALl();
  }
  getALl() {
    this.services = this.serviceService.getAll();
  }

}
