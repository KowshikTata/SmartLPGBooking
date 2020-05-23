import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {Admin} from "../common/admin";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http:HttpClient) { }

  authenticate(username, password) {
    return this.http.get<Admin>('http://localhost:8080/api/v1/loginAdmin'+'/userName'+'/password', ).pipe(
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
