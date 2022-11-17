package odusseus.pinakas.org;

import com.google.inject.AbstractModule;

	class PinakasModule extends AbstractModule {
		
		@Override
		protected void configure() {
			bind(IOutPut.class).to(OutPut.class);
		}

	}

