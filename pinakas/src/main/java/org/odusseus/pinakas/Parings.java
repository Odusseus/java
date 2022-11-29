package org.odusseus.pinakas;

import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public void Add(int whitenummer, int blacknummer)
	{
		ParingInterface paring = this.paringProvider.get();
		paring.setWhitenumber(whitenummer);
		paring.setBlacknumber(blacknummer);
				
		list.add(paring);
	}
	
	@Override
	public List<ParingInterface> getParings() {
		return this.list;		
	}

}
