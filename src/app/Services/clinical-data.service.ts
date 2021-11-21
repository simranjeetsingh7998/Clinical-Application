import { Patient } from './../Models/Patient';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AddPatient } from '../Models/AddPatient';
import { ClinicalData } from '../Models/ClinicalData';

@Injectable({
  providedIn: 'root'
})
export class ClinicalDataService {

  constructor(private http: HttpClient) { }

  // get all the patients in the database 
  getPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>("http://localhost:8080/clinicalservices/api/patients");
  }

  // adds patient to the database 
  sendData(data: AddPatient): Observable<AddPatient> {
    return this.http.post<AddPatient>("http://localhost:8080/clinicalservices/api/patients",data);
  }

  // Get single patient with the given id 
  getPatient(patientId: number): Observable<Patient> {
    return this.http.get<Patient>("http://localhost:8080/clinicalservices/api/patients/" + patientId);
  }

  // Adds new clinical data of the patient
  addClinicalData(patientId: number,data: ClinicalData): Observable<ClinicalData> {
    data.patientId = patientId;
    return this.http.post<ClinicalData>("http://localhost:8080/clinicalservices/api/clinicals",data);
  }

  // Gets data for analysis
  analyse(patientId: number): Observable<ClinicalData[]> {
    return this.http.get<ClinicalData[]>("http://localhost:8080/clinicalservices/api/clinicals/analyse/"+patientId);
  }
}
