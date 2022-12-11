package org.odusseus.pinakas.Implementation;

import java.time.LocalDate;

import org.odusseus.pinakas.Interface.CrossTableInterface;
import org.odusseus.pinakas.Interface.ParingsInterface;
import org.odusseus.pinakas.Interface.PlayersInterface;
import org.odusseus.pinakas.Interface.RoundsInterface;

import com.google.inject.Inject;

public class CrossTable implements CrossTableInterface {
	
	private String Name;
	private LocalDate date;
	
	private PlayersInterface players;
	private RoundsInterface rounds;
	private ParingsInterface parings;

	@Inject
	public CrossTable(PlayersInterface players,
		                          RoundsInterface rounds, 
		                          ParingsInterface parings) {
		this.players = players;
		this.rounds = rounds;
		this.parings = parings;
	}
	
	public PlayersInterface getPlayers() {
		return this.players;
	}
	
	public RoundsInterface getRounds() {
		return this.rounds;
	}	

}
