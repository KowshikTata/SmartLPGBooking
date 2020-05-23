import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ContactModel} from "./contact-model";

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  constructor(private http :HttpClient) { }

  private baseUrl = 'http://localhost:8080/api/contact';

  request(usermodel :ContactModel): Observable<any> {
    return this.http.post(`${this.baseUrl}`, usermodel);
  }
}
