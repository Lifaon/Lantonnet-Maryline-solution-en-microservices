package com.medilabo.note.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO implements Note {
	private String id;
	private Integer patientId;
	private String patientName;
	private String data;

	public NoteDTO(Note note) {
		this(note.getId(), note.getPatientId(), note.getPatientName(), note.getData());
	}
}
