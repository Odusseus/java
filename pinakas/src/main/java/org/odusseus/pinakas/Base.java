package org.odusseus.pinakas;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class Base {
	
	private OutPutInterface output;
	private PropertiesWrapperInterface properties;
	private PlayersInterface players;
	
	@Inject
	public Base(OutPutInterface output, PropertiesWrapper properties, PlayersInterface players) {
		this.output = output;
		this.properties = properties;
		this.players = players;
		
		//this.output.WriteCrossTable();		
		//System.out.println(this.properties.getProperty("names"));
	}
	
	public void Initialize () 
	{
		String names = this.properties.getProperty("names");
		List<String> nameList = Arrays.asList(names.split("\\s*,\\s*"));
		
		for (Iterator<String> iterator = nameList.iterator(); iterator.hasNext();) {
			players.Add(iterator.next());
		}
		
		for (int i = 0; i < players.getPlayers().size(); i++) {
			
			PlayerInterface player = players.getPlayers().get(i);
			
			System.out.println(String.format("Name: %d %s", player.getNumber(), player.getName()));		
		}
	}
	

}
