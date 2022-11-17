package odusseus.pinakas.org;

import com.google.inject.AbstractModule;

	class PinakasModuleFR extends AbstractModule {
		
		@Override
		protected void configure() {
			bind(IOutPut.class).to(Parler.class);
		}

	}

