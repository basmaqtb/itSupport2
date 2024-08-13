import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEquipementComponent } from './Components/add-equipement/add-equipement.component';
import { EquipementListComponent } from './Components/equipement-list/equipement-list.component'; // Import Equipement List Component
import { EquipementDetailComponent } from './Components/equipement-detail/equipement-detail.component'; // Import Equipement Detail Component

const routes: Routes = [  
  { path: 'equipements', component: EquipementListComponent }, // Route for listing Equipements
  { path: 'equipements/add', component: AddEquipementComponent }, // Route for creating Equipement
  { path: 'equipements/update/:id', component: AddEquipementComponent }, // Route for updating Equipement
  { path: 'equipements/:id', component: EquipementDetailComponent }, // Route for viewing Equipement details

  { path: '', redirectTo: '/equipements', pathMatch: 'full' },
  { path: '**', redirectTo: '/equipements' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
