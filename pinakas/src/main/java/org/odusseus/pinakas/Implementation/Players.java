package org.odusseus.pinakas.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.odusseus.pinakas.Interface.PlayerInterface;
import org.odusseus.pinakas.Interface.PlayersInterface;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Players implements PlayersInterface  {
	
	
	private List<PlayerInterface> list;
	private Provider<PlayerInterface> playerProvider;
	static final int MinNameLenght = 6;
	private int NameLenght = MinNameLenght;
	private int FieldLenght = MinNameLenght + 2;
	private int NumberOfPlayers;
	
    @Inject
    public Players(
    		Provider<PlayerInterface> playerProvider
    		)
	{
		this.list = new  ArrayList<PlayerInterface>();	
		this.playerProvider = playerProvider;
	}
	
	public void Add(String name)
	{
		PlayerInterface player = this.playerProvider.get();
		player.setName(name);
		this.NumberOfPlayers = this.list.size() + 1;
		player.setNumber(this.NumberOfPlayers);
				
		list.add(player);
		int nameLength = name.length();
		
		if (nameLength > this.NameLenght) {
			this.NameLenght = nameLength;
			this.FieldLenght = this.NameLenght + 2;
		  }
		
	}
	
	public int getNumberOfPlayers() {
		return NumberOfPlayers;
	}

	public int getFieldLenght() {
		return this.FieldLenght;		
	}
	
	public List<Integer> getListOfNumber(){
		List<Integer> returnList = new ArrayList<Integer>();
		Iterable<PlayerInterface> iterable = this.list;
		
		for (PlayerInterface player : iterable) {
		   returnList.add(player.getNumber());
		}
		
		return returnList;		
	}
	
	public List<PlayerInterface> getPlayers() {
		return this.list;		
	}
	
	public int size() {
		return this.list.size();
	}

}
