import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {Product} from "../../common/product";
import {AdminProductService} from "../../services/admin-product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {
  products: Observable<Product[]>;


  constructor(private adminGasService: AdminProductService,
              private router: Router) { }


  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.products = this.adminGasService.getGasList()
  }
  gasupdate(id: number){
    this.router.navigate(['home/update', id]);
  }


  // constructor() { }
  //
  // ngOnInit(): void {
  // }

}
