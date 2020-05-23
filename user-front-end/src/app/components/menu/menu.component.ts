import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
username: string;
  constructor() { }

  ngOnInit(): void {

  }
user()
{
  this.username = sessionStorage.getItem('username');
  return this.username;
}
}
