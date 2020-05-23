import { Component, OnInit } from '@angular/core';
import {Customer} from "../../customer";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerServiceService} from "../../customer-service.service";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customer : Customer = new Customer();
  check: Customer;
  submitted: boolean= false;
  connectionForm : FormGroup;
  constructor(private formBuilder: FormBuilder,private service:CustomerServiceService) { }
  username: string;
  ngOnInit(){
    this.connectionForm = this.formBuilder.group(
      {
        firstName : ['', [Validators.required, Validators.pattern("[A-Z][A-Z a-z]{2,30}")]],
        lastName : ['', [Validators.required, Validators.pattern("[A-Z][A-Z a-z]{2,30}")]],
        dob : ['', Validators.required],
        houseNo : ['', Validators.required],
        street : ['', Validators.required],
        city : ['', Validators.required],
        district : ['', Validators.required],
        state : ['', Validators.required],
        pincode : ['', [Validators.required, Validators.minLength(6), Validators.maxLength(6)]]
      }
    );
  }
  onSubmit(){
    this.submitted = true;
    this.save();
  }

  save(){
    this.username = sessionStorage.getItem('username');
    this.service.getEmailCheckLPG(this.username).subscribe(data=>{
      this.check=data;
      if(this.check!=null)
      {
        alert("You already have a connection of LPG!!")
      }
      else {
        this.newLPG();
        alert("Your LPG connection is successful!!")
      }
    })

  }
  newLPG()
  {
    this.service.createConnection(this.username, this.customer)
      .subscribe(data => console.log(data), error => console.log(error)
      );
    this.customer = new Customer();
  }
}
