import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
// import { Order } from '../common/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
private baseUrl  = 'http://localhost:8080/api/v1/orders';
  constructor(private http: HttpClient) {

}
  getOrder(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  getOrders(): Observable<any>
  {
      return this.http.get(`${this.baseUrl}`);
  }
  updateOrder(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
}
