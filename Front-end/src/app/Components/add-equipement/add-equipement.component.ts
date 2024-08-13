import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EquipementService } from '../../Service/equipement.service';
import { Equipement } from '../../Module/equipement';

@Component({
  selector: 'app-add-equipement',
  templateUrl: './add-equipement.component.html',
  styleUrls: ['./add-equipement.component.css']
})
export class AddEquipementComponent implements OnInit {

  equipementForm: FormGroup;
  isEditMode: boolean = false;
  equipementId: number | null = null;

  constructor(
    private fb: FormBuilder,
    private equipementService: EquipementService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.equipementForm = this.fb.group({
      etat: ['', Validators.required],
      marque: ['', Validators.required],
      model: ['', Validators.required],
      type: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.isEditMode = true;
        this.equipementId = +id;
        this.equipementService.getEquipement(this.equipementId).subscribe((equipement: Equipement) => {
          this.equipementForm.patchValue(equipement);
        });
      }
    });
  }

  onSubmit(): void {
    if (this.isEditMode && this.equipementId) {
      // Update existing equipement
      this.equipementService.updateEquipement(this.equipementId, this.equipementForm.value).subscribe(() =>
        this.router.navigate(['/equipements'])
      );
    } else {
      // Create new equipement
      this.equipementService.createEquipement(this.equipementForm.value).subscribe(() =>
        this.router.navigate(['/equipements'])
      );
    }
  }
}
