import { Component, OnInit } from '@angular/core';
import {Product} from "../../../common/product";
import {Observable} from "rxjs";
import {AdminProductService} from "../../../services/admin-product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.css']
})
export class ProductTableComponent implements OnInit {

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
    this.router.navigate(['update', id]);
  }

}
