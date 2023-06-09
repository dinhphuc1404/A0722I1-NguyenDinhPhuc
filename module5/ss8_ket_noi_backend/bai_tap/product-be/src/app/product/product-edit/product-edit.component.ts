import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Category} from '../../model/category';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Product} from '../../model/product';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    code: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category: new FormControl()
  });
  categories: Category[];
  id: number;
  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      // this.getProduct(this.id);
    });
  }

  ngOnInit(): void {
    this.productService.findById(this.id).subscribe(product => {
      this.productForm = new FormGroup({
        id: new FormControl(product.id),
        code: new FormControl(product.code),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description),
        category: new FormControl(product.category.id)
      });
    });
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    });
  }
  updateProduct(id: number) {
    const product = this.productForm.value;
    this.categoryService.findById(product.category).subscribe(next => {
      product.category = next;
      this.productService.update(id, product).subscribe(() => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Update thành công'  ,
          showConfirmButton: false,
          timer: 1500
        });
        this.router.navigateByUrl('/product/list');
      });
    });
  }
}
