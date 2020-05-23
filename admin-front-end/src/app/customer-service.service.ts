import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "./order";
import {Product} from "./product";
import {Registration} from "./registration";
import {Customer} from "./customer";
@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  private baseUrl = 'http://localhost:8080/api/customer/orders';
  private orderUrl='http://localhost:8080/api/customer/bookLPG';
  private productUrl='http://localhost:8080/api/customers/products';
  private registerUrl='http://localhost:8080/api/register';
  private mailUrl='http://localhost:8080/api/login/checkEmail/';
  private phoneUrl='http://localhost:8080/api/login/checkPhone/';
  private nameUrl='http://localhost:8080/api/login/checkName/';
  private bookingUrl  = "http://localhost:8080/api/newLPG/";
  private LPGCheckUrl= 'http://localhost:8080/api/customer/newLPGCheck';
  public userName: string;
  public password: string;
  constructor(private http: HttpClient) { }
  getOrders(userName: string): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.baseUrl}/${userName}`);
  }
  getProducts(): Observable<Product[]>
  {
    return this.http.get<Product[]>(`${this.productUrl}`);
  }
  bookOrder(userName:string):Observable<any>
  {
    return this.http.post(`${this.orderUrl}/${userName}`,null);
  }
  register(registration :Object):Observable<any>{
    return this.http.post(`${this.registerUrl}`,registration);
  }
getEmail(email: String):Observable<Registration>
{
  return this.http.get<Registration>(`${this.mailUrl}/${email}`);
}
  getPhone(phone: String):Observable<Registration>
  {
    return this.http.get<Registration>(`${this.phoneUrl}/${phone}`);
  }
  getuserName(name: String):Observable<Registration>
  {
    return this.http.get<Registration>(`${this.nameUrl}/${name}`);
  }
  createConnection(username:String,customer : Object) : Observable<Object>{
    return this.http.post(`${this.bookingUrl}/${username}`,customer);
  }
  getEmailCheckLPG(email: String):Observable<Customer>
  {
    return this.http.get<Customer>(`${this.LPGCheckUrl}/${email}`);
  }
 /*loginValidate(userName: string, password: string) {
    this.password = password;
    this.userName = userName;
    return this.http.get(
      ` ${this.loginUrl}/` + userName + "/" + password);
  }*/

}
