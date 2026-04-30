package com.medilabo.note.model;

import com.medilabo.note.api.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultNote implements Note {
	@Id
	private String id;

	private Integer patientId;
	private String patientName;
	private String data;

	public DefaultNote(Note note) {
		this(note.getId(), note.getPatientId(), note.getPatientName(), note.getData());
	}

	public DefaultNote(Integer patientId, String patientName, String data) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.data = data;
	}
}
