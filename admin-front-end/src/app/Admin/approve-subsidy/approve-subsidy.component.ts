import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {Customer} from "../../common/customer";
import {AdminCustomerService} from "../../services/admin-customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-approve-subsidy',
  templateUrl: './approve-subsidy.component.html',
  styleUrls: ['./approve-subsidy.component.css']
})
export class ApproveSubsidyComponent implements OnInit {

  customers: Observable<Customer[]>;


  constructor(private adminService: AdminCustomerService,
              private router: Router) { }


  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.customers = this.adminService.getRequestList();
  }
  customerupdate(id: number){
    this.router.navigate(['home/change', id]);
  }

}
