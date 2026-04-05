package com.medilabo.patient.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO implements Patient {
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private Gender gender;
	private String address;
	private String phoneNumber;

	public PatientDTO(Patient p) {
		this(p.getId(), p.getFirstName(), p.getLastName(), p.getDateOfBirth(), p.getGender(), p.getAddress(), p.getPhoneNumber());
	}
}
