package org.odusseus.matching;

import com.google.inject.AbstractModule;

	class AioniaModuleFR extends AbstractModule {
		
		@Override
		protected void configure() {
			bind(ISay.class).to(Parler.class);
		}

	}

