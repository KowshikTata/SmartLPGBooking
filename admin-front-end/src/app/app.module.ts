import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { ServicesComponent } from './components/services/services.component';
import { FooterComponent } from './components/footer/footer.component';
import { BookingComponent } from './components/booking/booking.component';
import { OrdersComponent } from './components/orders/orders.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { MenuComponent } from './components/menu/menu.component';
import { LogoutComponent } from './components/logout/logout.component';
import { HeaderComponent } from './components/header/header.component';
import {AuthGaurdService} from "./auth-gaurd.service";
import { CustomerComponent } from './components/customer/customer.component';
import { GiveupSubsidyComponent } from './components/giveup-subsidy/giveup-subsidy.component';
import { RequestSubsidyComponent } from './components/request-subsidy/request-subsidy.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';



const routes: Routes = [

  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'orders', component: OrdersComponent,canActivate:[AuthGaurdService] },
  {path: 'book' , component: BookingComponent,canActivate:[AuthGaurdService]},
  {path: 'home' , component: HomeComponent},
  {path: 'contactUs',component:ContactUsComponent},
  {path: 'aboutUs',component: AboutComponent},
  {path: 'newLPG',component: CustomerComponent,canActivate:[AuthGaurdService]},
  {path: 'requestSubsidy',component:RequestSubsidyComponent,canActivate: [AuthGaurdService]},
  {path: 'giveUp',component: GiveupSubsidyComponent,canActivate: [AuthGaurdService]},
  {path: 'menu' , component: MenuComponent,canActivate:[AuthGaurdService]},
  {path: 'register',component: RegisterComponent},
  {path: 'login',component: LoginComponent},
  { path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdService] },
  {path: '**', redirectTo: '/home', pathMatch: 'full'},

];
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    ServicesComponent,
    FooterComponent,
    BookingComponent,
    OrdersComponent,
    RegisterComponent,
    LoginComponent,
    MenuComponent,
    LogoutComponent,
    HeaderComponent,
    CustomerComponent,
    GiveupSubsidyComponent,
    RequestSubsidyComponent,
    ContactUsComponent


  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
