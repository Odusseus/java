package org.odusseus.pinakas.Implementation;

import org.odusseus.pinakas.Interface.ParingsInterface;
import org.odusseus.pinakas.Interface.RoundInterface;

import com.google.inject.Inject;

public class Round implements RoundInterface {
	
	private int number;
	private Parings parings;
	
	@Inject
	public Round(Parings parings) {
		this.parings = parings;
	}
	
	public int getNumber() {
		return this.number;		
	}
	
	public void setNumber(int number) {
		this.number = number;		
	}
	
	public ParingsInterface getParings() {
		return this.parings;
	}
	
}
