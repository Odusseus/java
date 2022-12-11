package org.odusseus.pinakas.Implementation;

import org.odusseus.pinakas.Interface.ParingInterface;

import com.google.inject.Inject;

public class Paring implements ParingInterface {
	
	private int roundnumber;
	private int whitenumber;
	private int blacknumber;
	
	@Inject
	public Paring() {
	}
	
	public int getRoundnumber() {
		return this.roundnumber;		
	}
	
	public void setRoundnumber(int roundnumber) {
		this.roundnumber = roundnumber;		
	}
	
	public int getWhitenumber() {
		return this.whitenumber;		
	}
	
	public void setWhitenumber(int whitenumber) {
		this.whitenumber = whitenumber;		
	}

	public int getBlacknumber() {
		return this.whitenumber;		
	}
	
	public void setBlacknumber(int blacknumber) {
		this.blacknumber = blacknumber;		
	}
}
