package com.medilabo.note.config;

import com.medilabo.note.model.DefaultNote;
import com.medilabo.note.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

	private final NoteRepository noteRepository;

	@Override
	public void run(ApplicationArguments args) {
		// Only init if empty
		if (noteRepository.count() == 0) {
			noteRepository.saveAll(List.of(
				new DefaultNote(1, "TestNone", "Le patient déclare qu'il 'se sent très bien' Poids égal ou inférieur au poids recommandé"),
				new DefaultNote(2, "TestBorderline", "Le patient déclare qu'il ressent beaucoup de stress au travail Il se plaint également que son audition est anormale dernièrement"),
				new DefaultNote(2, "TestBorderline", "Le patient déclare avoir fait une réaction aux médicaments au cours des 3 derniers mois Il remarque également que son audition continue d'être anormale"),
				new DefaultNote(3, "TestInDanger", "Le patient déclare qu'il fume depuis peu"),
				new DefaultNote(3, "TestInDanger", "Le patient déclare qu'il est fumeur et qu'il a cessé de fumer l'année dernière Il se plaint également de crises d’apnée respiratoire anormales Tests de laboratoire indiquant un taux de cholestérol LDL élevé"),
				new DefaultNote(4, "TestEarlyOnset", "Le patient déclare qu'il lui est devenu difficile de monter les escaliers Il se plaint également d’être essoufflé Tests de laboratoire indiquant que les anticorps sont élevés Réaction aux médicaments"),
				new DefaultNote(4, "TestEarlyOnset", "Le patient déclare qu'il a mal au dos lorsqu'il reste assis pendant longtemps"),
				new DefaultNote(4, "TestEarlyOnset", "Le patient déclare avoir commencé à fumer depuis peu Hémoglobine A1C supérieure au niveau recommandé"),
				new DefaultNote(4, "TestEarlyOnset", "Taille, Poids, Cholestérol, Vertige et Réaction")
			));
		}
	}
}
