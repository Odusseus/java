package org.odusseus.pinakas.Implementation;

import org.odusseus.pinakas.Interface.ParingInterface;

import com.google.inject.Provider;

public class ParingProvider implements Provider<ParingInterface> {
		
	public ParingInterface get() {
		ParingInterface paring = new Paring();
		return paring;		
	}

}
