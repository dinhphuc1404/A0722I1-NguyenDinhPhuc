import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Product} from '../../model/product';
import {Category} from '../../model/category';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  categories: Category[] = [];
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    code: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category: new FormControl()
  });


  constructor(private productService: ProductService, private categoryService: CategoryService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAllCategory();
  }

  createProduct() {
    const product = this.productForm.value;
    this.productService.save(product).subscribe(() => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Thêm mới thành công',
        showConfirmButton: false,
        timer: 1500
      });
      this.productForm.reset();
      this.router.navigateByUrl('product/list');
    });
  }

  getAllCategory() {
    this.categoryService.findAll().subscribe(categoires => {
      this.categories = categoires;
    });
  }
}
