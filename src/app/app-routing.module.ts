import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPatientComponent } from './Components/add-patient/add-patient.component';
import { AnalyseDataComponent } from './Components/analyse-data/analyse-data.component';
import { ChartGeneratorComponent } from './Components/chart-generator/chart-generator.component';
import { CollectClinicalsComponent } from './Components/collect-clinicals/collect-clinicals.component';
import { HomeComponent } from './Components/home/home.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'patientDetails/:patientId', component: CollectClinicalsComponent},
  {path: 'addPatient' , component: AddPatientComponent},
  {path: 'analyse/:patientId', component: AnalyseDataComponent},
  {path: 'chart/:compinentName/:patientId', component:ChartGeneratorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
