package org.odusseus.pinakas.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.odusseus.pinakas.Interface.ParingInterface;
import org.odusseus.pinakas.Interface.ParingsInterface;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Parings implements ParingsInterface    {
	
	List<ParingInterface> list;
	private Provider<ParingInterface> paringProvider;
	
    @Inject
    public Parings(
    		Provider<ParingInterface> paringProvider
    		)
	{
		this.list = new  ArrayList<ParingInterface>();	
		this.paringProvider = paringProvider;
	}
	
	public void Add(int whitenummer, int blacknummer)
	{
		ParingInterface paring = this.paringProvider.get();
		paring.setWhitenumber(whitenummer);
		paring.setBlacknumber(blacknummer);
				
		list.add(paring);
	}
	
	public List<ParingInterface> getParings() {
		return this.list;		
	}

}
