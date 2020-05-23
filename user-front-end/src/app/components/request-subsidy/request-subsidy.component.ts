import { Component, OnInit } from '@angular/core';
import {Customer} from "../../customer";
import {ActivatedRoute, Router} from "@angular/router";
import {SubsidyService} from "../../subsidy.service";

@Component({
  selector: 'app-request-subsidy',
  templateUrl: './request-subsidy.component.html',
  styleUrls: ['./request-subsidy.component.css']
})
export class RequestSubsidyComponent implements OnInit {
  customer: Customer;
  username: string;
  flag: number;
  constructor(private service: SubsidyService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
  }

  requestS() {
    this.username = sessionStorage.getItem('username');
    this.service.requestSubsidy(this.username).subscribe(data => { this.flag = data;
      if(this.flag==0)
      {
        alert("Already Requested!!")
      }
      else if(this.flag==1)
      {
        alert("Your request processed")
      }
      else if(this.flag==2)
      {
        alert("You Already GivedUpSubsidy. Can't Request Another")
      }
      else if(this.flag==-1)
      {
        alert("Please register for LPG Connection !!")
      }
    });

  }
}
