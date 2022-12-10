package org.odusseus.pinakas.Implementation;

import org.odusseus.pinakas.Interface.RoundInterface;

import com.google.inject.Provider;

public class RoundProvider implements Provider<RoundInterface> {
		
	public RoundInterface get() {
		RoundInterface round = new Round();
		return round;		
	}

}
