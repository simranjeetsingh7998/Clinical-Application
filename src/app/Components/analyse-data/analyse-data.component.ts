import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClinicalData } from 'src/app/Models/ClinicalData';
import { Patient } from 'src/app/Models/Patient';
import { ClinicalDataService } from 'src/app/Services/clinical-data.service';

@Component({
  selector: 'app-analyse-data',
  templateUrl: './analyse-data.component.html',
  styleUrls: ['./analyse-data.component.css']
})
export class AnalyseDataComponent implements OnInit {

  patientReports!: ClinicalData[];
  patientId!: number;
  error!: string;
  patient: Patient = new Patient();

  constructor(private service: ClinicalDataService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(param => this.patientId = param['patientId']);
    this.analyse();
  }

  analyse() {
    this.service.getPatient(this.patientId).subscribe(
      patient => this.patient = patient,
      error => this.error = error
    );
    this.service.analyse(this.patientId).subscribe(
      patient => {this.patientReports = patient; console.log(this.patientReports)},
      error => this.error = error
    );
  }

  handleClick() {
    this.router.navigate(['/']);
  }
}
