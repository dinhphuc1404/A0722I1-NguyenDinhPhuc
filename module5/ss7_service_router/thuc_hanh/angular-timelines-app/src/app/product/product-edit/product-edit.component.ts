import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Category} from '../../model/category';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CategoryService} from '../../service/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  id: number;
  categories: Category[];
  productForm: FormGroup = new FormGroup({
    name: new FormControl(),
    price: new FormControl(),
    ngayRaMat: new FormControl(),
    ngayNgungSanXuat: new FormControl(),
    category: new FormControl(),
  });

  constructor(private productService: ProductService, private activateRoute: ActivatedRoute,
              private categoryService: CategoryService, private router: Router) {
    this.activateRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });
  }

  ngOnInit(): void {
    this.productService.findById(this.id).subscribe(product => {
      this.productForm = new FormGroup({
        name: new FormControl(product.name, [Validators.required]),
        price: new FormControl(product.price, [Validators.required]),
        ngayRaMat: new FormControl(product.ngayRaMat, [Validators.required]),
        ngayNgungSanXuat: new FormControl(product.ngayNgungSanXuat, [Validators.required]),
        category: new FormControl(product.category.id, [Validators.required]),
      });
    });
    this.getAllCategory();
  }

  edit(id: number) {
    const product = this.productForm.value;
    this.categoryService.findById(product.category).subscribe(data => {
      product.category = data;
      this.productService.update(id, product).subscribe(() => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Update thành công',
          showConfirmButton: false,
          timer: 1500
        });
        this.router.navigateByUrl('product/list');
      });
    });
  }

  getAllCategory() {
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    });
  }
}
