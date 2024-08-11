package me.wavetech.wavecarpet;

import carpet.api.settings.Rule;

@SuppressWarnings("unused")
public class WaveCarpetSettings {
	public static final String WAVETECH = "WaveTech";

	@Rule(categories = { WAVETECH })
	public static boolean stopLightRecalculationDataFix = false;
}
