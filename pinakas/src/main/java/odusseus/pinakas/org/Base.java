package odusseus.pinakas.org;

import com.google.inject.Inject;

public class Base {
	
	private IOutPut output;
	
	@Inject
	public Base(IOutPut output) {
		this.output = output;
		this.output.WriteCrossTable();
	}

}
