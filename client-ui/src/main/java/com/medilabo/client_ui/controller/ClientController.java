package com.medilabo.client_ui.controller;

import com.medilabo.client_ui.feign.NoteProxy;
import com.medilabo.client_ui.feign.PatientProxy;
import com.medilabo.patient.api.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ClientController {

	@Autowired
	private PatientProxy patientProxy;

	@Autowired
	private NoteProxy noteProxy;

	@GetMapping
	public String accueil(Model model) {
		List<PatientDTO> patients = patientProxy.getAll();
		model.addAttribute("patients", patients);
		return "accueil";
	}

	@GetMapping("/patients/{id}")
	public String patient(@PathVariable Integer id, Model model) {
		PatientDTO patient = patientProxy.get(id);
		List<String> notes = noteProxy.getPatientData(id);
		model.addAttribute("patient", patient);
		model.addAttribute("notes", notes);
		return "patient";
	}
}
