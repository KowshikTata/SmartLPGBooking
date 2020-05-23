import { Component, OnInit } from '@angular/core';
import {ContactService} from "../../contact.service";
import {HttpClient} from "@angular/common/http";
import {ContactModel} from "../../contact-model";

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {
  usermodel :ContactModel = new ContactModel();

  constructor(private http: HttpClient, private contactService :ContactService) { }

  private request() {
    this.contactService.request(this.usermodel)
      .subscribe(data => console.log(data));
  }

  onSubmit() {
    // this.request();
    this.processForm();
  }

  processForm() {
    const allInfo = `My name is ${this.usermodel.name}. My email is ${this.usermodel.email}. My message is ${this.usermodel.message}`;
    alert(allInfo);
    this.request();
  }
  ngOnInit(): void {
  }
}
