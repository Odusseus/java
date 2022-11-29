package org.odusseus.pinakas;

import java.util.List;

public interface RoundsInterface {

	RoundInterface Add();
	
	List<RoundInterface> getRounds();

	void setNumberOf(int numberOf);

	int getNumberOf();

}