package org.odusseus.pinakas.Implementation;

import org.odusseus.pinakas.Interface.PlayerInterface;

import com.google.inject.Inject;

public class Player implements PlayerInterface {
	
	private int number;
	private String name;
	
	@Inject
	public Player() {
	}
	
	public int getNumber() {
		return this.number;		
	}
	
	public String getName() {
		return this.name;		
	}
	
	public void setNumber(int number) {
		this.number = number;		
	}
	
	public void setName(String name) {
		this.name = name;		
	}
}
