import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';
import {Product} from '../../model/product';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[];
  product: Product;
  p = 1;
  mgs = false;
  constructor(private productService: ProductService,
              private router: Router) {
  }

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

  removeProduct() {
    this.productService.deleteById(this.product.id).subscribe(() => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Xóa thành công',
        showConfirmButton: false,
        timer: 1500
      });
      this.getAllProduct();
    });
  }

  search(inputSerach: HTMLInputElement) {
    if (inputSerach.value === '') {
      Swal.fire('Vui lòng nhập');
    } else {
      this.productService.search(inputSerach.value).subscribe(next => {
        this.products = next;
        if (this.products.length === 0) {
          this.mgs = true;
        } else {
          this.mgs = false;
        }
      });
    }
  }
}
