package aionia;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Go {

	public static void main(String[] args) {
		//ISay say = new Say();
		//say.Hello();
		
		Injector injector = Guice.createInjector(new AioniaModuleFR());
		
		Base base = injector.getInstance(Base.class);
	}

}
