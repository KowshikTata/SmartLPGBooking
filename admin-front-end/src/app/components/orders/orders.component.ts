import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CustomerServiceService} from "../../customer-service.service";
import {Observable} from "rxjs";
import {Order} from "../../order";


@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  objOrder: Order[];
  username: string;

  constructor(private service: CustomerServiceService, private router: Router) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.username = sessionStorage.getItem('username');


    this.service.getOrders(this.username).subscribe(data => { this.objOrder = data; });

  }

}
