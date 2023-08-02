import { Component, OnInit } from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  products: Product[];
  product: Product;
  p = 1;
  mgs = false;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getAllProduct();
  }

  getAllProduct() {
    this.productService.findAll().subscribe(data => {
      this.products = data;
    });
  }

  getProduct(id: number) {
    this.productService.findById(id).subscribe(data => {
      this.product = data;
    });
  }

  delete() {
    this.productService.detele(this.product.id).subscribe(() => {
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Xóa thành công',
        showConfirmButton: false,
        timer: 1500
      });
      this.getAllProduct();
    });
  }

  searchDate(start: HTMLInputElement, end: HTMLInputElement) {
    if (start.value === '' || end.value === '') {
      Swal.fire('Vui lòng nhập');
    } else {
      this.productService.searchDate(start.value, end.value).subscribe(data => {
        this.products = data;
      });
    }
  }

  searchName(name: HTMLInputElement) {
    if (name.value === '') {
      Swal.fire('Vui lòng nhập');
    } else {
      this.productService.searchName(name.value).subscribe(data => {
        this.products = data;
        if (this.products.length === 0) {
          this.mgs = true;
        } else {
          this.mgs = false;
        }
      });
    }
  }
}
