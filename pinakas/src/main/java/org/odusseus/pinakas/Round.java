package org.odusseus.pinakas;

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
