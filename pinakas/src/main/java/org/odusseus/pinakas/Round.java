package org.odusseus.pinakas;

import com.google.inject.Inject;

public class Round implements RoundInterface {
	
	private int number;
	
	@Inject
	public Round() {
	}
	
	@Override
	public int getNumber() {
		return this.number;		
	}
	
	@Override
	public void setNumber(int number) {
		this.number = number;		
	}
	
}
