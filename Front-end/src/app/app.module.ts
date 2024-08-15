import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { EquipementService } from './Service/equipement.service';
import { AddEquipementComponent } from './Components/add-equipement/add-equipement.component';
import { EquipementListComponent } from './Components/equipement-list/equipement-list.component';
import { EquipementDetailComponent } from './Components/equipement-detail/equipement-detail.component';
import { LoginComponent } from './Components/login/login.component';  // Added LoginComponent

@NgModule({
  declarations: [
    AppComponent,
    AddEquipementComponent,
    EquipementListComponent,
    EquipementDetailComponent,
    LoginComponent  // Added LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [EquipementService],  // Providing EquipementService
  bootstrap: [AppComponent]
})
export class AppModule { }
