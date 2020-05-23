import { Component, OnInit } from '@angular/core';
import {Customer} from "../../customer";
import {SubsidyService} from "../../subsidy.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-giveup-subsidy',
  templateUrl: './giveup-subsidy.component.html',
  styleUrls: ['./giveup-subsidy.component.css']
})
export class GiveupSubsidyComponent implements OnInit {
  customer: Customer;
  username: string;
  flag: number;
  constructor(private service: SubsidyService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }
  giveUp() {
    this.username = sessionStorage.getItem('username');
    this.service.giveUpSubsidy(this.username).subscribe(data => { this.flag = data;
      if(this.flag==0)
      {
        alert("Please register for LPG Connection !!")
      }
      else if(this.flag==1)
      {
        alert("You have Successfully GivedUp Subsidy")
      }
      else if(this.flag==2)
      {
        alert("You have Already GivedUpSubsidy. Can't Process Request")
      }
      else if(this.flag==3)
      {
        alert("Please join Pahal Subsidy!!")
      }
    });

  }
}
