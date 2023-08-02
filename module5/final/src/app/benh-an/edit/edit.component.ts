import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {BenhAnService} from '../../service/benh-an.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  id: number;
  benhAnhForm: FormGroup = new FormGroup({
    maBenhAn: new FormControl(),
    maBenhNhan: new FormControl(),
    tenBenhNhan: new FormControl(),
    ngayNhapVien: new FormControl(),
    ngayRaVien: new FormControl(),
    liDoNhapVien: new FormControl(),
    phuongPhapDieuTri: new FormControl(),
    bacSiDieuTri: new FormControl()
  });


  constructor(private benhAnService: BenhAnService, private activateRoute: ActivatedRoute,
              private router: Router) {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });
  }

  ngOnInit(): void {
    this.benhAnService.findById(this.id).subscribe(benhAn => {
      this.benhAnhForm = new FormGroup({
        maBenhAn: new FormControl({ value: benhAn.maBenhAn, disabled: true }),
        maBenhNhan: new FormControl(benhAn.maBenhNhan),
        tenBenhNhan: new FormControl(benhAn.tenBenhNhan, [Validators.required, Validators.pattern('^[^0-9]*$')]),
        ngayNhapVien: new FormControl(benhAn.ngayNhapVien, [Validators.required]),
        ngayRaVien: new FormControl(benhAn.ngayRaVien, [Validators.required]),
        liDoNhapVien: new FormControl(benhAn.liDoNhapVien, [Validators.required]),
        phuongPhapDieuTri: new FormControl(benhAn.phuongPhapDieuTri, [Validators.required]),
        bacSiDieuTri: new FormControl(benhAn.bacSiDieuTri, [Validators.required]),
      });
    });
  }

  edit(id: number) {
    const benhAn = this.benhAnhForm.value;
    this.benhAnService.update(id, benhAn).subscribe(() => {
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Update thành công',
        showConfirmButton: false,
        timer: 1500
      });
      this.router.navigateByUrl('benhAn/list');
    });
  }
}
