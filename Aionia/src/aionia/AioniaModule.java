package aionia;

import com.google.inject.AbstractModule;

	class AioniaModule extends AbstractModule {
		
		@Override
		protected void configure() {
			bind(ISay.class).to(Say.class);
		}

	}

