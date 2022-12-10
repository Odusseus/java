package org.odusseus.pinakas;

import org.odusseus.pinakas.Implementation.OutPut;
import org.odusseus.pinakas.Implementation.ParingProvider;
import org.odusseus.pinakas.Implementation.Parings;
import org.odusseus.pinakas.Implementation.PlayerProvider;
import org.odusseus.pinakas.Implementation.Players;
import org.odusseus.pinakas.Implementation.PropertiesWrapper;
import org.odusseus.pinakas.Implementation.RoundProvider;
import org.odusseus.pinakas.Implementation.Rounds;
import org.odusseus.pinakas.Interface.OutPutInterface;
import org.odusseus.pinakas.Interface.ParingInterface;
import org.odusseus.pinakas.Interface.ParingsInterface;
import org.odusseus.pinakas.Interface.PlayerInterface;
import org.odusseus.pinakas.Interface.PlayersInterface;
import org.odusseus.pinakas.Interface.PropertiesWrapperInterface;
import org.odusseus.pinakas.Interface.RoundInterface;
import org.odusseus.pinakas.Interface.RoundsInterface;

import com.google.inject.AbstractModule;

class BaseModule extends AbstractModule {
		
	@Override
	protected void configure() {
		bind(OutPutInterface.class).to(OutPut.class);
		bind(PropertiesWrapperInterface.class).to(PropertiesWrapper.class);
		bind(PlayersInterface.class).to(Players.class);
		bind(PlayerInterface.class).toProvider(PlayerProvider.class);
		bind(RoundsInterface.class).to(Rounds.class);
		bind(RoundInterface.class).toProvider(RoundProvider.class);	
		bind(ParingsInterface.class).to(Parings.class);
		bind(ParingInterface.class).toProvider(ParingProvider.class);
	}	
}

