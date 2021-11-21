import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from 'src/app/Models/Patient';
import { ClinicalDataService } from 'src/app/Services/clinical-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  patients: Patient[] = [];
  error!: string;

  constructor(private service: ClinicalDataService, private router: Router) { }

  ngOnInit(): void {
    this.getPatients();
  }

  getPatients() {
    this.service.getPatients().subscribe(
      patients => this.patients = patients,
      error => this.error = error
    );
  }

  addData(patientId: number) {
    this.router.navigate(['/patientDetails/',patientId]);
  }

  analyse(patientId: number) {
    this.router.navigate(['/analyse/',patientId]);
  }

  addPatient() {
    this.router.navigate(['/addPatient']);
  }
}