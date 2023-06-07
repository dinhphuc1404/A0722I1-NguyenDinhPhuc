import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';
import {Product} from '../../model/product';
import {Category} from '../../model/category';
import {CategoryService} from '../../service/category.service';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  products: Product[];
  categories: Category[];
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
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    });
  }
  submit() {
    const product = this.productForm.value;
    this.productService.saveProduct(product).subscribe(data => {
      this.router.navigateByUrl('/produc  t/list');
    });
  }

}
