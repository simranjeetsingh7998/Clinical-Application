package com.clinical.utility;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.clinical.entity.ClinicalData;

public class BMICalculator {

	public static ClinicalData calculateBMI(ClinicalData cd) {
		ClinicalData bmiData = new ClinicalData();
		String[] heightAndWeight = cd.getComponentValue().split("/");
		if (heightAndWeight != null && heightAndWeight.length > 1) {
			float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
			float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters * heightInMeters);

			bmiData.setComponentName("bmi");
			bmiData.setComponentValue(Float.toString(bmi));
			bmiData.setMeasuredDateTime(Timestamp.valueOf(LocalDateTime.now()));
		}
		return bmiData;
	}
}
