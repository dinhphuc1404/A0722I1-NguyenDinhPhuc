import { Injectable } from '@angular/core';
import {CustomerType} from '../model/customer-type';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  API = 'http://localhost:3000/customerTypes';
  constructor(private httpClient: HttpClient) { }
  getAllType(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(this.API);
  }
  findById(id: number): Observable<CustomerType> {
    return this.httpClient.get<CustomerType>(this.API + '/' + id);
  }
}
