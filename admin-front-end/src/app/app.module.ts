import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { AppComponent } from './app.component';
import { AdminHomePageComponent } from './Admin/admin-home-page/admin-home-page.component';
// import { SidenavigationComponent } from './Admin/sidenavigation/sidenavigation.component';
// import { TopNavigationComponent } from './Admin/top-navigation/top-navigation.component';
// import { FooterComponent } from './Admin/footer/footer.component';
import { DashBoardComponent } from './Admin/dash-board/dash-board.component';
import { ApproveSubsidyComponent } from './Admin/approve-subsidy/approve-subsidy.component';
import { UpdateGasCostComponent } from './Admin/update-gas-cost/update-gas-cost.component';
//import { ViewGasPriceComponent } from './Admin/view-gas-price/view-gas-price.component';
import { UpdateSubsidyComponent } from './Admin/update-subsidy/update-subsidy.component';
import { UserTableComponent } from './Admin/tables/user-table/user-table.component';
import { ProductTableComponent } from './Admin/tables/product-table/product-table.component';
import { AllTablesComponent } from './Admin/tables/all-tables/all-tables.component';
// import { LineChartsComponent } from './Admin/charts/line-charts/line-charts.component';
// import { BarChartsComponent } from './Admin/charts/bar-charts/bar-charts.component';
// import { AllChartsComponent } from './Admin/charts/all-charts/all-charts.component';
import { LoginComponent } from './Admin/authentication/login/login.component';
import { LogoutComponent } from './Admin/authentication/logout/logout.component';
import { ViewProductComponent } from './Admin/view-product/view-product.component';
import { BookingDetailsComponent } from './Admin/booking-details/booking-details.component';
import { UpdateBookingStatusComponent } from './Admin/update-booking-status/update-booking-status.component';

import { AdminLogoutComponent } from './Admin/admin-logout/admin-logout.component';
const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {path: 'login', component: LoginComponent},
  {path:'home/logout',redirectTo: 'login', pathMatch: 'full' },

  {
    path: 'home',
    component: AdminHomePageComponent,
   children: [
     { path: '', redirectTo: 'dashboards', pathMatch: 'full' },
  {path: 'dashboards', component: DashBoardComponent},
  {path: 'pahal', component: ApproveSubsidyComponent},
  {path: 'update', component: ViewProductComponent},
  {path: 'change/:id', component: UpdateSubsidyComponent},
  {path: 'update/:id', component: UpdateGasCostComponent},
  {path: 'tables', component: AllTablesComponent},
     {path: 'orders', component: BookingDetailsComponent},
     {path: 'order/:id', component: UpdateBookingStatusComponent},
     {path: 'logout', component: LogoutComponent},

  // { path: 'home', component: AdminHomePageComponent },

   ],
},


  ];
@NgModule({
  declarations: [
    AppComponent,
    AdminHomePageComponent,

    DashBoardComponent,
    ApproveSubsidyComponent,
    UpdateGasCostComponent,
   // ViewGasPriceComponent,
    UpdateSubsidyComponent,
    UserTableComponent,
    ProductTableComponent,
    AllTablesComponent,

    LoginComponent,
    LogoutComponent,
    ViewProductComponent,
    BookingDetailsComponent,
    UpdateBookingStatusComponent,

    AdminLogoutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
