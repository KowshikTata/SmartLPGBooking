import { Injectable } from '@angular/core';

import {map} from "rxjs/operators";
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Registration} from "./registration";
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http:HttpClient) { }
  authenticate(username, password) {
    return this.http.get<Registration>('http://localhost:8080/api/login'+'/userName'+'/password', ).pipe(
      map(
        userData => {
          sessionStorage.setItem('username', username);

          return userData;
        }
      )
    );
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
