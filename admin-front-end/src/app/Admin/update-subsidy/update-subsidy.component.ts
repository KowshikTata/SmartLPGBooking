import { Component, OnInit } from '@angular/core';
import {Customer} from "../../common/customer";
import {ActivatedRoute, Router} from "@angular/router";
import {AdminCustomerService} from "../../services/admin-customer.service";

@Component({
  selector: 'app-update-subsidy',
  templateUrl: './update-subsidy.component.html',
  styleUrls: ['./update-subsidy.component.css']
})
export class UpdateSubsidyComponent implements OnInit {

  id: number;
  customer: Customer;
  isupdated=false;

  constructor(private route: ActivatedRoute,private router: Router,
              private adminService: AdminCustomerService) { }

  ngOnInit() {
    this.customer = new Customer();

    this.id = this.route.snapshot.params['id'];

    this.adminService.getCustomer(this.id)
      .subscribe(data => {
        console.log(data)
        this.customer = data;
      }, error => console.log(error));
  }

  updateCustomer() {
    this.adminService.updateCustomer(this.id, this.customer)
      .subscribe(data => {this.isupdated=true,console.log(data)}, error => console.log(error));
    this.customer = new Customer();
    // this.gotoList();
  }

  onSubmit() {
    this.updateCustomer()
  }

  // gotoList() {
  //   this.router.navigate(['/dashboards']);
  // }

}
