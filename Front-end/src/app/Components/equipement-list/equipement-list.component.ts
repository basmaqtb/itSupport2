import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EquipementService } from '../../Service/equipement.service';
import { Equipement } from '../../Module/equipement';

@Component({
  selector: 'app-equipement-list',
  templateUrl: './equipement-list.component.html',
  styleUrls: ['./equipement-list.component.css']
})
export class EquipementListComponent implements OnInit {
  equipements: Equipement[] = [];
  filteredEquipements: Equipement[] = [];
  searchTerm: string = '';

  constructor(private equipementService: EquipementService, private router: Router) {}

  ngOnInit(): void {
    this.loadEquipements();
  }

  loadEquipements(): void {
    this.equipementService.getEquipements().subscribe(
      (data) => {
        this.equipements = data;
        this.filteredEquipements = data; // Initialize filteredEquipements with the complete list
      },
      (error) => {
        console.error('Error fetching equipements', error);
      }
    );
  }

  deleteEquipement(id: number): void {
    if (confirm('Are you sure you want to delete this equipement?')) {
      this.equipementService.deleteEquipement(id).subscribe(
        () => {
          this.equipements = this.equipements.filter(equipement => equipement.idEquipement !== id);
          this.searchEquipements(); // Reapply filter after deletion
        },
        (error) => {
          console.error('Error deleting equipement', error);
        }
      );
    }
  }

  editEquipement(id: number): void {
    this.router.navigate(['/equipements/edit', id]);
  }

  searchEquipements(): void {
    if (this.searchTerm === '') {
      this.filteredEquipements = this.equipements;
    } else {
      this.filteredEquipements = this.equipements.filter(equipement =>
        equipement.marque.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    }
  }
}
