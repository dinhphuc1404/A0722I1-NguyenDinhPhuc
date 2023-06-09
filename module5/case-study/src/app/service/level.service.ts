import { Injectable } from '@angular/core';
import {Level} from '../model/level';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LevelService {
  API = ' http://localhost:3000/levels';
  constructor(private httpClient: HttpClient) { }
  getAllLevel(): Observable<Level[]> {
    return this.httpClient.get<Level[]>(this.API);
  }
  findById(id: number): Observable<Level> {
    return this.httpClient.get<Level>(this.API + '/' + id);
  }
}
