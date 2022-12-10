package org.odusseus.pinakas;

import com.google.inject.Provider;

public class ParingProvider implements Provider<ParingInterface> {
		
	public ParingInterface get() {
		ParingInterface paring = new Paring();
		return paring;		
	}

}
