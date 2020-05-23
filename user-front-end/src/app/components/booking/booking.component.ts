import { Component, OnInit } from '@angular/core';
import {CustomerServiceService} from "../../customer-service.service";
import {Product} from "../../product";
import {Router} from "@angular/router";
import {Customer} from "../../customer";

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
product: Product[];
username: string;
check: Customer;
  constructor(private service: CustomerServiceService,private router:Router) { }

  ngOnInit(){
    this.getProducts();
  }
getProducts()
{
  this.service.getProducts().subscribe(data => {
    this.product = data;
  });

}
bookLPG()
{
  this.username = sessionStorage.getItem('username');
  this.service.getEmailCheckLPG(this.username).subscribe(data=>{
    this.check=data;
    if(this.check!=null)
    {
      this.service.bookOrder(this.username).subscribe(data=>{console.log(data)})
      alert("Your order is booked!!")
    }
    else {

      alert("Please apply for new LPG Connection!!")
    }
  })


}

}
