import { Component, OnInit } from '@angular/core';
import {Product} from "../../common/product";
import {ActivatedRoute, Router} from "@angular/router";
import {AdminProductService} from "../../services/admin-product.service";
import {Order} from "../../common/order";
import {OrderService} from "../../services/order.service";

@Component({
  selector: 'app-update-booking-status',
  templateUrl: './update-booking-status.component.html',
  styleUrls: ['./update-booking-status.component.css']
})
export class UpdateBookingStatusComponent implements OnInit {

  id: number;
  objOrder: Order;
  isupdated=false;

  constructor(private route: ActivatedRoute,private router: Router,
              private orderService: OrderService) { }

  ngOnInit() {
    this.objOrder = new Order();

    this.id = this.route.snapshot.params['id'];

    this.orderService.getOrder(this.id)
      .subscribe(data => {
        console.log(data)
        this.objOrder = data;
      }, error => console.log(error));
  }

  updateOrder() {
    this.orderService.updateOrder(this.id,this.objOrder)
      .subscribe(data => {this.isupdated=true,console.log(data)},  error => console.log(error));
    this.objOrder = new Order();
    // this.gotoList();
  }

  onSubmit() {
    this.updateOrder();

  }

}
