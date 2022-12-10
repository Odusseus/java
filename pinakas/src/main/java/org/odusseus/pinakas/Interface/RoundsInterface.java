package org.odusseus.pinakas.Interface;

import java.util.List;

public interface RoundsInterface {

	RoundInterface Add();
	
	List<RoundInterface> getRounds();

	void setNumberOf(int numberOf);

	int getNumberOf();

}