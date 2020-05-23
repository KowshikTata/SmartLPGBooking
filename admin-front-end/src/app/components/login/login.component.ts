import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {CustomerServiceService} from "../../customer-service.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../authentication.service";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public userName: string;
  public password: string;
  public loginFlag: boolean = false;
  loginForm: FormGroup;
  invalidLogin = false;
  submitted: boolean = false;
  id: number;
  constructor(private service:CustomerServiceService,private router: Router,private formBuilder: FormBuilder,private loginservice: AuthenticationService) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      usrid: ["", Validators.required],
      password: ["", Validators.required],
    });
  }
  public authenticate() {
    this.submitted = true;
    if (this.loginForm.valid) {
      this.userName = this.loginForm.controls.usrid.value;
      this.password = this.loginForm.controls.password.value;
      this.loginservice
        .authenticate(this.userName, this.password)
        .subscribe((data) => {
            this.router.navigate(["/menu"]);
        });
    } else {
      this.invalidLogin = true;
    }
  }
}
