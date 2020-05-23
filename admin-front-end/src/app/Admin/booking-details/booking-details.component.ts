import { Component, OnInit } from '@angular/core';
import {OrderService} from "../../services/order.service";
import {Order} from "../../common/order";
import {Router} from "@angular/router";
import {Observable} from "rxjs";

@Component({
  selector: 'app-booking-details',
  templateUrl: './booking-details.component.html',
  styleUrls: ['./booking-details.component.css']
})
export class BookingDetailsComponent implements OnInit {
objOrder : Observable<Order[]>;

  constructor(private orderService: OrderService,private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.objOrder = this.orderService.getOrders();
  }
  orderupdate(id: number)
  {
    this.router.navigate(['home/order', id]);
  }

}
