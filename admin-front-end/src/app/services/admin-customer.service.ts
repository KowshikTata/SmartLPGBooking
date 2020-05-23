import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AdminCustomerService {

  private baseUrl = 'http://localhost:8080/api/v1/customers';

  private requestUrl='http://localhost:8080/admin/view/PahalRequests';
  // hideSideNav: boolean = false;
  //
  //
  //
  // toggleSideNav(): void {
  //   this.hideSideNav = !this.hideSideNav;
  // }
  constructor(private http: HttpClient) { }
  getCustomer(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  getRequestList(): Observable<any> {
    return this.http.get(`${this.requestUrl}`);
  }
  updateCustomer(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
  getCustomersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
