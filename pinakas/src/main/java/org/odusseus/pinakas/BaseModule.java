package org.odusseus.pinakas;

import org.odusseus.pinakas.Implementation.OutPut;
import org.odusseus.pinakas.Implementation.PropertiesWrapper;
//import org.odusseus.pinakas.Implementation.CrossTable;
import org.odusseus.pinakas.Interface.OutPutInterface;
//import org.odusseus.pinakas.Implementation.ParingProvider;
//import org.odusseus.pinakas.Implementation.Parings;
//import org.odusseus.pinakas.Implementation.PlayerProvider;
//import org.odusseus.pinakas.Implementation.Players;
import org.odusseus.pinakas.Interface.PropertiesWrapperInterface;

import com.google.inject.AbstractModule;

class BaseModule extends AbstractModule {
		
	@Override
	protected void configure() {
		bind(OutPutInterface.class).to(OutPut.class);
		bind(PropertiesWrapperInterface.class).to(PropertiesWrapper.class);
	}	
}

