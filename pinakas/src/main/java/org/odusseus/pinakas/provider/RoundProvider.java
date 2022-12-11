package org.odusseus.pinakas.provider;

import org.odusseus.pinakas.Implementation.Round;
import org.odusseus.pinakas.Interface.RoundInterface;

import com.google.inject.Provider;

public class RoundProvider implements Provider<RoundInterface> {
		
	public RoundInterface get() {
		RoundInterface round = new Round(null);
		return round;		
	}

}
