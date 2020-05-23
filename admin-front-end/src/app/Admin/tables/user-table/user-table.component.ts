import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {Customer} from "../../../common/customer";
import {AdminCustomerService} from "../../../services/admin-customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent implements OnInit {

  customers: Observable<Customer[]>;
  constructor(private adminService: AdminCustomerService,
              private router: Router) { }


  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.customers = this.adminService.getCustomersList();
  }
}
