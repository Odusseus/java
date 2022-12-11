package org.odusseus.pinakas;

import org.odusseus.pinakas.Implementation.Base;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Go {

	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(new BaseModule());
		
		Base base = injector.getInstance(Base.class);
		
		base.Initialize();
		
		base.WriteCrossTable();
	}

}
