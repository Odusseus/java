package org.odusseus.pinakas.provider;

import org.odusseus.pinakas.Implementation.Paring;
import org.odusseus.pinakas.Interface.ParingInterface;

import com.google.inject.Provider;

public class ParingProvider implements Provider<ParingInterface> {
		
	public ParingInterface get() {
		ParingInterface paring = new Paring();
		return paring;		
	}

}
