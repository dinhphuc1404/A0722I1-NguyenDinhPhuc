import { Component, OnInit } from '@angular/core';
import {BenhAn} from '../../model/BenhAn';
import {BenhAnService} from '../../service/benh-an.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  benhAns: BenhAn[];
  benhAn: BenhAn;
  p = 1;
  constructor(private benhAnService: BenhAnService) { }

  ngOnInit(): void {
    this.findAll();
  }
  findAll() {
    this.benhAnService.findAll().subscribe(data => {
      this.benhAns = data;
    });
  }

  getBenhAn(id: number) {
    this.benhAnService.findById(id).subscribe(data => {
      this.benhAn = data;
    });
  }

  delete() {
    this.benhAnService.delete(this.benhAn.id).subscribe(() => {
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Xóa thành công',
        showConfirmButton: false,
        timer: 1500
      });
      this.findAll();
    });
  }
}
