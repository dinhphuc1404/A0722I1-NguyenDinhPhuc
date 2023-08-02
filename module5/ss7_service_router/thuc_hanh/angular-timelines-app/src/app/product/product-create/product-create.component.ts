import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import {Category} from '../../model/category';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  currentDate: string;
  categories: Category[];
  productForm: FormGroup = new FormGroup({
    name: new FormControl(),
    price: new FormControl(),
    ngayRaMat: new FormControl(),
    ngayNgungSanXuat: new FormControl(),
    category: new FormControl(),
  });

  constructor(private producrService: ProductService, private categoryService: CategoryService,
              private router: Router) {
    this.currentDate = this.getCurrentDate();
  }

  ngOnInit(): void {
    this.productForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      ngayRaMat: new FormControl('', [Validators.required]),
      ngayNgungSanXuat: new FormControl('', [Validators.required]),
      category: new FormControl('', [Validators.required]),
    });
    this.getAllCategory();
  }
  getCurrentDate(): string {
    const date = new Date();
    const year = date.getFullYear();
    const month = this.formatNumber(date.getMonth() + 1);
    const day = this.formatNumber(date.getDate());
    return `${year}-${month}-${day}`;
  }

  private formatNumber(num: number): string {
    return num < 10 ? `0${num}` : `${num}`;
  }
  submit() {
    const product = this.productForm.value;
    this.producrService.create(product).subscribe(() => {
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Thêm mới thành công',
        showConfirmButton: false,
        timer: 1500
      });
      this.router.navigateByUrl('product/list');
    });
  }

  getAllCategory() {
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    });
  }
}
