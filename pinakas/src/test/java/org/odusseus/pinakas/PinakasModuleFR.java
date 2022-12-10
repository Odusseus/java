package org.odusseus.pinakas;

import org.odusseus.pinakas.Implementation.Parler;
import org.odusseus.pinakas.Implementation.Players;
import org.odusseus.pinakas.Implementation.PropertiesWrapper;
import org.odusseus.pinakas.Interface.OutPutInterface;
import org.odusseus.pinakas.Interface.PlayersInterface;
import org.odusseus.pinakas.Interface.PropertiesWrapperInterface;

import com.google.inject.AbstractModule;

class PinakasModuleFR extends AbstractModule {
		
	@Override
	protected void configure() {
		bind(OutPutInterface.class).to(Parler.class);
		bind(PropertiesWrapperInterface.class).to(PropertiesWrapper.class);
		bind(PlayersInterface.class).to(Players.class);			
	}
}

