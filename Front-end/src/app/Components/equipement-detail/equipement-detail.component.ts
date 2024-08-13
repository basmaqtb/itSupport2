import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EquipementService } from '../../Service/equipement.service';
import { Equipement } from '../../Module/equipement';

@Component({
  selector: 'app-equipement-detail',
  templateUrl: './equipement-detail.component.html',
  styleUrls: ['./equipement-detail.component.css']
})
export class EquipementDetailComponent implements OnInit {
  equipement: Equipement | undefined;

  constructor(
    private route: ActivatedRoute,
    private equipementService: EquipementService
  ) { }

  ngOnInit(): void {
    this.getEquipement();
  }

  getEquipement(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.equipementService.getEquipement(id).subscribe((data: Equipement) => {
      this.equipement = data;
    });
  }
}
