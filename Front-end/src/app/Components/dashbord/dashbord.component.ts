import { Component } from '@angular/core';
import { JwtService } from 'src/app/Service/jwt.service';

@Component({
  selector: 'app-dashbord',
  templateUrl: './dashbord.component.html',
  styleUrls: ['./dashbord.component.css']
})
export class DashbordComponent {

  userCount: number | undefined;

  constructor(
    private service: JwtService
  ){}

  ngOnInit(): void {
    this.loadUserCount();
  }

  private loadUserCount(): void {
    this.service.getUserCount().subscribe(
      (count: number) => {
        this.userCount = count;
      },
      (error) => {
        console.error('Error fetching user count', error);
      }
    );
  }
}
