import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Equipement } from '../Module/equipement'; 


@Injectable({
  providedIn: 'root'
})
export class EquipementService {
  private apiUrl = 'http://localhost:8082/auth/admin/equipements'; 

  constructor(private http: HttpClient) { }

  getEquipements(): Observable<Equipement[]> {
    const headers = this.createAuthorizationHeader();
    return this.http.get<Equipement[]>(`${this.apiUrl}/show`, { headers });
  }

  getEquipement(id: number): Observable<Equipement> {
    return this.http.get<Equipement>(`${this.apiUrl}/get/${id}`);
  }

  createEquipement(equipement: Equipement): Observable<Equipement> {
    const headers = this.createAuthorizationHeader();
    return this.http.post<Equipement>(`${this.apiUrl}/add`, equipement, { headers });
  }
  
  updateEquipement(id: number, equipement: Equipement): Observable<Equipement> {
    const headers = this.createAuthorizationHeader();
    return this.http.put<Equipement>(`${this.apiUrl}/update/${id}`, equipement, { headers });
  }

  deleteEquipement(id: number): Observable<void> {
    const headers = this.createAuthorizationHeader();
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`, { headers });
  }


  private createAuthorizationHeader(): HttpHeaders | undefined {
    const jwtToken = localStorage.getItem('jwt');
    if (jwtToken) {
      console.log("JWT token found in local storage", jwtToken);
      return new HttpHeaders().set("Authorization", "Bearer " + jwtToken);
    } else {
      console.log("JWT token not found in local storage");
      return undefined;
    }
  }

}
