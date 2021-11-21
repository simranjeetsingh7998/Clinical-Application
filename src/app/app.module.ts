import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Components/home/home.component';
import { CollectClinicalsComponent } from './Components/collect-clinicals/collect-clinicals.component';
import { AddPatientComponent } from './Components/add-patient/add-patient.component';
import { AnalyseDataComponent } from './Components/analyse-data/analyse-data.component';
import { ChartGeneratorComponent } from './Components/chart-generator/chart-generator.component';
import { ClinicalDataService } from './Services/clinical-data.service';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CollectClinicalsComponent,
    AddPatientComponent,
    AnalyseDataComponent,
    ChartGeneratorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [ClinicalDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
