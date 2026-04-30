package com.medilabo.risk.controller;

import com.medilabo.patient.api.Patient;
import com.medilabo.risk.api.Risk;
import com.medilabo.risk.api.RiskApi;
import com.medilabo.risk.feign.NoteProxy;
import com.medilabo.risk.feign.PatientProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class RiskController implements RiskApi {

	final private PatientProxy patientProxy;
	final private NoteProxy noteProxy;

	static private final List<String> triggers = Stream.of(
			"Hémoglobine A1C",
			"Microalbumine",
			"Taille",
			"Poids",
			"Fumeur",
			"Fumeuse",
			"Anormal",
			"Cholestérol",
			"Vertiges",
			"Rechute",
			"Réaction",
			"Anticorps"
	).map(String::toLowerCase).toList();

	@Override
	public Risk getUserRisk(Integer id) {
		final Patient patient = patientProxy.get(id);
		final List<String> notes = noteProxy.getPatientData(id);

		int nb = 0;
		for (String note : notes) {
			for (String trigger : triggers) {
				if (note.toLowerCase().contains(trigger))
					nb++;
			}
		}

		final int age = Period.between(patient.getDateOfBirth(), LocalDate.now()).getYears();

		if (age < 30) {
			switch (patient.getGender()) {
				case F:
					if (nb >= 7) return Risk.EarlyOnset;
					if (nb >= 4) return Risk.InDanger;
					break;
				case M:
					if (nb >= 5) return Risk.EarlyOnset;
					if (nb >= 3) return Risk.InDanger;
					break;
				default:
					throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Genre non pris en charge");
			}
		} else {
			if (nb >= 8) return Risk.EarlyOnset;
			if (nb >= 6) return Risk.InDanger;
			if (nb >= 2) return Risk.Borderline;
		}

		return Risk.None;
	}
}
