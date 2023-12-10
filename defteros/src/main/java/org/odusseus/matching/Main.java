package org.odusseus.matching;

import org.odusseus.matching.Base;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Injector injector = Guice.createInjector(new AioniaModuleFR());
		
		injector.getInstance(Base.class);
    }
}