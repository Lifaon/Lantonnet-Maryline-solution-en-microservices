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

	void setId(Integer id);
	void setFirstName(String firstName);
	void setLastName(String lastName);
	void setDateOfBirth(LocalDate dateOfBirth);
	void setGender(Gender gender);
	void setAddress(String address);
	void setPhoneNumber(String phoneNumber);

}
