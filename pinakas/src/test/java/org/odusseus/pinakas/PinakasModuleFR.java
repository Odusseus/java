package org.odusseus.pinakas;

import com.google.inject.AbstractModule;

class PinakasModuleFR extends AbstractModule {
		
	@Override
	protected void configure() {
		bind(OutPutInterface.class).to(Parler.class);
		bind(PropertiesWrapperInterface.class).to(PropertiesWrapper.class);
		bind(PlayersInterface.class).to(Players.class);			
	}
}

