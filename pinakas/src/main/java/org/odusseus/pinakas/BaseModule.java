package org.odusseus.pinakas;

import com.google.inject.AbstractModule;

class BaseModule extends AbstractModule {
		
	@Override
	protected void configure() {
		bind(OutPutInterface.class).to(OutPut.class);
		bind(PropertiesWrapperInterface.class).to(PropertiesWrapper.class);
		bind(PlayersInterface.class).to(Players.class);
		//bind(PlayerBuilderInterface.class).to(PlayerBuilder.class);
		bind(PlayerInterface.class).toProvider(PlayerProvider.class);		
	}	
}

