import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClinicalData } from 'src/app/Models/ClinicalData';
import { Patient } from 'src/app/Models/Patient';
import { ClinicalDataService } from 'src/app/Services/clinical-data.service';

@Component({
  selector: 'app-collect-clinicals',
  templateUrl: './collect-clinicals.component.html',
  styleUrls: ['./collect-clinicals.component.css']
})
export class CollectClinicalsComponent implements OnInit{

  patient: Patient = new Patient();
  patientId!: number;
  error!: string;
  success!: string;
  submitted: boolean = false;
  clinicalDataForm!: FormGroup;
  clinicalData: ClinicalData = new ClinicalData();

  constructor(
    private service: ClinicalDataService, 
    private route: ActivatedRoute, 
    private fb: FormBuilder,
    private router: Router
    ) { }
  
  ngOnInit(): void {
    this.submitted = false;
    this.getPatient();
    this.clinicalDataForm = this.fb.group({
      componentName: ['', [Validators.required]],
      componentValue: ['', [Validators.required]]
    });
    
  }

  getPatient() {
    this.route.params.subscribe(param => this.patientId = param['patientId']);
    this.service.getPatient(this.patientId).subscribe(
      patient => this.patient = patient,
      error => this.error = error
    );
  }

  handleSubmit() {
    this.submitted = true;
    this.service.addClinicalData(this.patientId,this.clinicalDataForm.value).subscribe(
      (data) => {this.clinicalData = data},
      error => this.error = error
    );
  }

  handleClick() {
    this.router.navigate(['/']);
  }
}