package org.odusseus.pinakas.Implementation;

import org.odusseus.pinakas.Interface.RoundInterface;

import com.google.inject.Inject;

public class Round implements RoundInterface {
	
	private int number;
	
	@Inject
	public Round() {
	}
	
	public int getNumber() {
		return this.number;		
	}
	
	public void setNumber(int number) {
		this.number = number;		
	}
	
}