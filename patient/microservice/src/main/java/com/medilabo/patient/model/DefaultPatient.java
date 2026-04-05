package com.medilabo.patient.model;

import com.medilabo.patient.api.Gender;
import com.medilabo.patient.api.Patient;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultPatient implements Patient {

	@Id
	@GeneratedValue
	private Integer id;

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String address;
	private String phoneNumber;

	public DefaultPatient(Patient p) {
		this(p.getId(), p.getFirstName(), p.getLastName(), p.getDateOfBirth(), p.getGender(), p.getAddress(), p.getPhoneNumber());
	}
}