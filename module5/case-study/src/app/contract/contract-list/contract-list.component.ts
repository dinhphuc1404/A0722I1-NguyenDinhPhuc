import { Component, OnInit } from '@angular/core';
import {Contract} from '../../model/contract';
import {ContractService} from '../../service/contract.service';
import {FormControl, FormGroup} from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contracts: Contract[];
  contract: Contract;
  p: number;
  searchForm: FormGroup;
  constructor(private contracService: ContractService) {
  }

  ngOnInit(): void {
    this.getAllContrac();
  }
  getAllContrac() {
    this.contracService.getAllContract().subscribe(data => {
      this.contracts = data;
    });
  }



  search(ngayLamHopDong: HTMLInputElement, ngaKetThuc: HTMLInputElement) {
    if (ngayLamHopDong.value === '' || ngaKetThuc.value === '') {
      Swal.fire('Vui lòng nhập');
    } else {
      this.contracService.search(ngayLamHopDong.value, ngaKetThuc.value).subscribe(next => {
        this.contracts = next;
      });
    }
  }
}
