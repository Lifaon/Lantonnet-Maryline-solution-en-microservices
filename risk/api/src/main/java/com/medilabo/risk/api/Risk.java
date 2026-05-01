package com.medilabo.risk.api;

public enum Risk {
	None,
	Borderline,
	InDanger,
	EarlyOnset;

	public String toFrench() {
		return switch (this) {
			case None -> "Aucun risque";
			case Borderline -> "Risque limité";
			case InDanger -> "Danger";
			case EarlyOnset -> "Apparition précoce";
		};
	}
}
