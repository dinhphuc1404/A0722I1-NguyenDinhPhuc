import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  API = 'http://localhost:3000/products';
  constructor(private httpClient: HttpClient) { }
  findAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.API);
  }

  create(product): Observable<Product> {
    return this.httpClient.post<Product>(this.API, product);
  }
  findById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(this.API + '/' + id);
  }
  update(id: number, product: Product): Observable<Product> {
    return this.httpClient.put<Product>(this.API + '/' + id, product);
  }
  detele(id: number): Observable<Product> {
    return this.httpClient.delete<Product>(this.API + '/' + id);
  }

  searchDate(start: string, end: string): Observable<Product[]> {
    let key = '';
    if (start !== '' && end !== '') {
      key += '?ngayRaMat_gte=' + start + '&ngayRaMat_lte=' + end;
    } else if (start !== '') {
      key += '?ngayRaMat_gte=' + start;
    } else if (end !== '') {
      key += '?ngayRaMat_lte' + end;
    }
    return this.httpClient.get<Product[]>(this.API + key);
  }

  searchName(name: string): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.API + '?name_like=' + name);
  }
}
