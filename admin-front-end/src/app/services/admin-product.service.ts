import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AdminProductService {

  private baseUrl = 'http://localhost:8080/api/v1/products';

  constructor(private http: HttpClient) { }
  getGas(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  getGasList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  updateGas(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
}
