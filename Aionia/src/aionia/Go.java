package aionia;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Go {

	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(new AioniaModuleFR());
		
		injector.getInstance(Base.class);
	}

}
