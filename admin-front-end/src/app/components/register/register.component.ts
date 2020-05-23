import {Component, OnInit} from '@angular/core';
import {CustomerServiceService} from "../../customer-service.service";
import {Registration} from "../../registration";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registration: Registration = new Registration();
  reg: Registration;
  /*reg1: Registration= new Registration();
  reg2: Registration= new Registration();*/
/*var1: number=1;
var2: number=1;
var3: number=1;*/
  constructor(private service: CustomerServiceService) {
  }

  ngOnInit(): void {
  }

  register() {
    this.service.getEmail(this.registration.email).subscribe(data => {
      this.reg = data;

      /*if (this.reg != null) {
        alert("Email  Already Exists!!");
      }
      else {
        this.check();
      }*/
    })
    this.service.register(this.registration).subscribe(data => {
      this.registration = data;
      alert("Reg sucess!!")
    })
    /*if (this.reg != null) {
      alert("Email  Already Exists!!");
    }
    else{
      this.service.register(this.registration).subscribe(data => {
        this.registration = data;
      })
      alert("Registration success!!")
    }*/
  }
  check()
  {
    this.service.register(this.registration).subscribe(data => {
      this.registration = data;
    })
    alert("Registration success!!");
  }
    /*console.log(this.reg);
    this.service.getPhone(this.registration.phone).subscribe(data => {
      this.reg1 = data;
      if(this.reg1!=null)
      {
        this.var2+=1;
      }
    })
    this.service.getuserName(this.registration.userName).subscribe(data => {
      this.reg2 = data;
      if(this.reg2!=null)
      {
        this.var3+=1;
      }
      console.log(this.reg2);
    })

    if(this.var1==1&&this.var2==1&&this.var3==1)
    {
      this.finalreg();
    }
    else {
      alert("Details  Already Exists!!");
    }*/
    /*else if (this.reg1 != null) {
      alert("Phone Number  Already Exists!!");

    } else if (this.reg2 != null) {
      alert("userName  Already Exists!!");

    }*/


}
