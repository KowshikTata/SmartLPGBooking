import { Component, OnInit } from '@angular/core';
import {Product} from "../../common/product";
import {ActivatedRoute, Router} from "@angular/router";
import {AdminProductService} from "../../services/admin-product.service";

@Component({
  selector: 'app-update-gas-cost',
  templateUrl: './update-gas-cost.component.html',
  styleUrls: ['./update-gas-cost.component.css']
})
export class UpdateGasCostComponent implements OnInit {

  id: number;
  product: Product;
  isupdated=false;

  constructor(private route: ActivatedRoute,private router: Router,
              private adminGasService: AdminProductService) { }

  ngOnInit() {
    this.product = new Product();

    this.id = this.route.snapshot.params['id'];

    this.adminGasService.getGas(this.id)
      .subscribe(data => {
        console.log(data)
        this.product = data;
      }, error => console.log(error));
  }

  updateGas() {
    this.adminGasService.updateGas(this.id,this.product)
      .subscribe(data => {this.isupdated=true,console.log(data)},  error => console.log(error));
    this.product = new Product();
    // this.gotoList();
  }

  onSubmit() {
    this.updateGas()

  }

  // constructor() { }
  //
  // ngOnInit(): void {
  // }

}
