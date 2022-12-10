package org.odusseus.pinakas;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.lang.String;

import org.odusseus.pinakas.Implementation.OutPut;
import org.odusseus.pinakas.Implementation.PropertiesWrapper;
import org.odusseus.pinakas.Interface.OutPutInterface;
import org.odusseus.pinakas.Interface.ParingsInterface;
import org.odusseus.pinakas.Interface.PlayerInterface;
import org.odusseus.pinakas.Interface.PlayersInterface;
import org.odusseus.pinakas.Interface.PropertiesWrapperInterface;
import org.odusseus.pinakas.Interface.RoundInterface;
import org.odusseus.pinakas.Interface.RoundsInterface;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class Base {
	
	private OutPutInterface output;
	private PropertiesWrapperInterface properties;
	private PlayersInterface players;
	private RoundsInterface rounds;
	private ParingsInterface parings;
	
	@Inject
	public Base(OutPutInterface output, PropertiesWrapper properties, PlayersInterface players,
			    RoundsInterface rounds, ParingsInterface parings) {
		this.output = output;
		this.properties = properties;
		this.players = players;
		this.rounds = rounds;
		this.parings = parings;

	}
	
	public void Initialize () 
	{
		String names = this.properties.getProperty("names");
		List<String> nameList = Arrays.asList(names.split("\\s*,\\s*"));
		
		for (Iterator<String> iterator = nameList.iterator(); iterator.hasNext();) {
			this.players.Add( (iterator.next()).strip());
		}
		
		int numberOf = players.getPlayers().size();
		if (numberOf % 2 != 0) numberOf ++;
		this.rounds.setNumberOf(numberOf);
		
		for (int i = 0; i < players.getPlayers().size(); i++) {
			
			PlayerInterface player = players.getPlayers().get(i);
			
			System.out.println(String.format("Name: %d %s", player.getNumber(), player.getName()));		
		}
		
		List<Integer> players = this.players.getListOfNumber();

		for (int i = 0; i < this.rounds.getNumberOf(); i++) {
			RoundInterface round = this.rounds.Add();
			
		}
	}
		
	public  void WriteCrossTable() {
		this.output.WriteCrossTable( this.players, this.rounds);
		
	  }
}
