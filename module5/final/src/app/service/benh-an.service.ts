import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BenhAn} from '../model/BenhAn';

@Injectable({
  providedIn: 'root'
})
export class BenhAnService {
  API = 'http://localhost:3000/benhAns';
  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<BenhAn[]> {
    return this.httpClient.get<BenhAn[]>(this.API);
  }

  findById(id: number): Observable<BenhAn> {
    return this.httpClient.get<BenhAn>(this.API + '/' + id);
  }
  update(id: number, benhAn: BenhAn): Observable<BenhAn> {
    return this.httpClient.put<BenhAn>(this.API + '/' + id, benhAn);
  }
  delete(id: number): Observable<BenhAn> {
    return this.httpClient.delete<BenhAn>(this.API + '/' + id);
  }
}
