import { Timestamp } from "rxjs";
import { Patient } from "./Patient";

export class ClinicalData {
    patientId!: number;
    componentName!: string;
    componentValue!: string;
    measuredDateTime!: Date;
    patient!: Patient;
}