package org.odusseus.matching;

import com.google.inject.Inject;

public class Base {
	
	private ISay say;
	
	@Inject
	public Base(ISay say) {
		this.say = say;
		this.say.Hello();
	}

}
