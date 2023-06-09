import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {RentalType} from '../model/rentalType';
import {CustomerType} from '../model/customer-type';

@Injectable({
  providedIn: 'root'
})
export class RentalTypeService {
  API = 'http://localhost:3000/rentalTypes';
  constructor(private httpClient: HttpClient) { }
  getAllRentalType(): Observable<RentalType[]> {
    return this.httpClient.get<RentalType[]>(this.API);
  }

  findById(id: number): Observable<RentalType> {
   return this.httpClient.get<CustomerType>(this.API + '/' + id);
  }
}
