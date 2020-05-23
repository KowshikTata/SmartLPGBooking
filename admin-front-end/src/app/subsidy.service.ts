import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class SubsidyService {
subsidyUrl='http://localhost:8080/api/customer/requsetPahal/';
giveUpUrl='http://localhost:8080/api/customer/giveUpPahal/';
  constructor(private http: HttpClient) { }
  requestSubsidy(username: string): Observable<number>
  {
    return this.http.get<number>(`${this.subsidyUrl}/${username}`);
  }

  giveUpSubsidy(username: string):Observable<number>
  {
    return this.http.get<number>(`${this.giveUpUrl}/${username}`);
  }
}
