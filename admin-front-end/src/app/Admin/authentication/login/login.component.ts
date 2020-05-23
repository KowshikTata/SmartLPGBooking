import { Component, OnInit } from '@angular/core';
import {AdminLoginService} from "../../../services/admin-login.service";
import {Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Admin} from "../../../common/admin";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  invalidLogin = false;

  constructor(private router: Router, private adminLoginService: AdminLoginService) {
  }

  admin: Admin = new Admin();
  adminSaveForm = new FormGroup({
    userName: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),

  });

  loginUser() {
    this.admin = new Admin();
    this.admin.password = this.UserPassword.value;
    this.admin.userName = this.UserName.value;
    this.login();
  }

  login() {
    this.adminLoginService.loginUser(this.admin).subscribe(
      data => {
        console.log("response received")
        this.router.navigate(['/home'])
      },
      error => {
        console.log("exception occured");
        // this.msg = "UserName or password entered is wrong";
        this.invalidLogin = true;

      }
    );
  }

  get UserName() {
    return this.adminSaveForm.get('userName');
  }

  get UserPassword() {
    return this.adminSaveForm.get('password');
  }


  ngOnInit() {



  }
}
