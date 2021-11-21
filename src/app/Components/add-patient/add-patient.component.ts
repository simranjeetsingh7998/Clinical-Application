import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClinicalDataService } from 'src/app/Services/clinical-data.service';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  addPatientForm!: FormGroup;
  success!: string;
  error!: string;
  submitted:boolean = false;

  constructor(private fb: FormBuilder, private service: ClinicalDataService, private router: Router) { }

  ngOnInit(): void {
    this.submitted = false;
    this.addPatientForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      age: ['', Validators.required]
    });
  }

  handleSubmit() {
    this.submitted = true;
    this.service.sendData(this.addPatientForm.value).subscribe();
  }

  handleClick() {
    this.router.navigate(['/']);
  }
}
