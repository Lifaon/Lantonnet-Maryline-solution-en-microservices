package com.medilabo.patient.api;

import java.time.LocalDate;

public interface Patient {

	Integer getId();
	String getFirstName();
	String getLastName();
	LocalDate getDateOfBirth();
	Gender getGender();
	String getAddress();
	String getPhoneNumber();

}
