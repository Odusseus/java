package org.odusseus.pinakas.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.odusseus.pinakas.Interface.RoundInterface;
import org.odusseus.pinakas.Interface.RoundsInterface;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Rounds implements RoundsInterface  {
	
	int numberOfRounds;
	List<RoundInterface> list;
	private Provider<RoundInterface> roundProvider;
	
    @Inject
    public Rounds(
    		Provider<RoundInterface> roundProvider
    		)
	{
		this.list = new ArrayList<RoundInterface>();	
		this.roundProvider = roundProvider;
	}
	
	public RoundInterface Add()
	{
		RoundInterface round = this.roundProvider.get();
		round.setNumber(this.list.size() + 1);
				
		list.add(round);
		return round;
	}
	
	public List<RoundInterface> getRounds() {
		return this.list;		
	}
	
	public void setNumberOf(int numberOf)
	{
		this.numberOfRounds = numberOf;
	}
	
	public int getNumberOf()
	{
		return this.numberOfRounds;
	}

}
