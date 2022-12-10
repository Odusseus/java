package org.odusseus.pinakas;

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
	
	@Override
	public void setRoundnumber(int roundnumber) {
		this.roundnumber = roundnumber;		
	}
	
	@Override
	public int getWhitenumber() {
		return this.whitenumber;		
	}
	
	@Override
	public void setWhitenumber(int whitenumber) {
		this.whitenumber = whitenumber;		
	}

	@Override
	public int getBlacknumber() {
		return this.whitenumber;		
	}
	
	@Override
	public void setBlacknumber(int blacknumber) {
		this.blacknumber = blacknumber;		
	}
}
