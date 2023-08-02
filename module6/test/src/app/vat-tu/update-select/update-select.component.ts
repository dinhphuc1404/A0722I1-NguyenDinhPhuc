import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {VatTuService} from '../../service/vat-tu.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-update-select',
  templateUrl: './update-select.component.html',
  styleUrls: ['./update-select.component.css']
})
export class UpdateSelectComponent implements OnInit {
  vatTutForm: FormGroup;
  id: number;

  constructor(private vatTuService: VatTuService, private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      const vatTu = this.getProduct(this.id);
      this.vatTutForm = new FormGroup({
        id: new FormControl(vatTu.id),
        maVatTu: new FormControl(vatTu.maVatTu),
        name: new FormControl(vatTu.name),
        soLuong: new FormControl(vatTu.soLuong),
        donVi: new FormControl(vatTu.donVi),
        donGia: new FormControl(vatTu.donGia),
        ghiChu: new FormControl(vatTu.ghiChu)
      });
  });
  }
  ngOnInit(): void {
  }

  updateVatTu(id: number) {
    const select = this.vatTutForm.value;
    this.vatTuService.updateSelect(id, select);
    this.vatTutForm.reset();
    this.router.navigateByUrl('/select/list');
  }

  getProduct(id: number) {
    return this.vatTuService.findById(id);
  }
}
