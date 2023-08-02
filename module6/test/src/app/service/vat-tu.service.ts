import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {VatTu} from '../model/vat-tu';

@Injectable({
  providedIn: 'root'
})
export class VatTuService {
  selectedVatTu: VatTu[] = [];
  API = 'http://localhost:3000/vatTus';
  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<VatTu[]> {
    return this.httpClient.get<VatTu[]>(this.API);
  }
  findAllSelect() {
    return this.selectedVatTu;
  }
  addSelectedItem(item: any) {
    this.selectedVatTu.push(item);
  }

  removeSelectedItem(item: any) {
    const index = this.selectedVatTu.findIndex((selectedItem) => selectedItem.id === item.id);
    if (index !== -1) {
      this.selectedVatTu.splice(index, 1);
    }
  }
  findById(id: number) {
    return this.selectedVatTu.find(select => select.id === id);
  }
  updateSelect(id: number, select: VatTu) {
    for (let i = 0; i < this.selectedVatTu.length; i++) {
      if (this.selectedVatTu[i].id === id) {
        this.selectedVatTu[i] = select;
      }
    }
  }
  deleteById(id: number) {
    this.selectedVatTu = this.selectedVatTu.filter(select => {
      return select.id !== id;
    });
  }
}
