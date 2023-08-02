import { Component, OnInit } from '@angular/core';
import {VatTu} from '../../model/vat-tu';
import {VatTuService} from '../../service/vat-tu.service';
import {Router} from '@angular/router';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  p = 1;
  vatTus: VatTu[];

  selectedProducts: any[] = [];
  constructor(public vatTuService: VatTuService, private router: Router) { }

  ngOnInit(): void {
    this.findAll();
  }
  findAll() {
    this.vatTuService.findAll().subscribe(data => {
      this.vatTus = data;
    });
  }

  chonChekBox(item: VatTu) {
    if (item.chon) {
      this.vatTuService.addSelectedItem(item);
    } else {
      this.vatTuService.removeSelectedItem(item);
    }
  }
  them() {
    // this.vatTus = this.vatTus.filter(v => !v.chon);
    this.router.navigate(['/select/list']);
  }
}
