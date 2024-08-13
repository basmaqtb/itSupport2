import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { EquipementService } from './Service/equipement.service';
import { AddEquipementComponent } from './Components/add-equipement/add-equipement.component';
import { EquipementListComponent } from './Components/equipement-list/equipement-list.component';
import { EquipementDetailComponent } from './Components/equipement-detail/equipement-detail.component';







// import { EventComponent } from './Module/event.ts/event.component';
@NgModule({
  declarations: [
    AppComponent,
    AddEquipementComponent,
    EquipementListComponent,
    EquipementDetailComponent       // EventComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
    
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
