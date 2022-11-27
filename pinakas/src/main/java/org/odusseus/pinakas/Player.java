package org.odusseus.pinakas;

public class Player implements PlayerInterface {
	
	private int number;
	private String name;
	
	@Override
	public int getNumber() {
		return this.number;		
	}
	
	@Override
	public String getName() {
		return this.name;		
	}
	
	@Override
	public void setNumber(int number) {
		this.number = number;		
	}
	
	@Override
	public void setName(String name) {
		this.name = name;		
	}
}
