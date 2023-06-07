import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  product: Product;
  constructor(private productService: ProductService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.productService.getAll().subscribe(data => {
      this.products = data;
    });
  }
}
