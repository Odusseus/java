package org.odusseus.pinakas.Implementation;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.odusseus.pinakas.Interface.CrossTableInterface;
import  org.odusseus.pinakas.Interface.OutPutInterface;
import org.odusseus.pinakas.Interface.PlayerInterface;
import org.odusseus.pinakas.CrossTableModule;
import org.odusseus.pinakas.Interface.PropertiesWrapperInterface;

import java.lang.String;


import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Base {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
	
	private OutPutInterface output;
	private PropertiesWrapperInterface properties;
	private CrossTableInterface crossTable;
	
	@Inject
	public Base(OutPutInterface output, PropertiesWrapper properties) {
		this.output = output;
		this.properties = properties;
		
		Injector injector = Guice.createInjector(new CrossTableModule());
		
		this.crossTable = injector.getInstance(CrossTable.class);
	}
	
	public void Initialize () 
	{
		String names = this.properties.getProperty("names");
		List<String> nameList = Arrays.asList(names.split("\\s*,\\s*"));
		
			
		for (Iterator<String> iterator = nameList.iterator(); iterator.hasNext();) {
			this.crossTable.getPlayers().Add( (iterator.next()).strip());
		}
		
		int numberOfPlayers = this.crossTable.getPlayers().size();
		if (numberOfPlayers % 2 != 0) {
			this.crossTable.getPlayers().Add( "?");
		};
		this.crossTable.getRounds().setNumberOf(numberOfPlayers - 1);
		
		for (int i = 0; i <  this.crossTable.getPlayers().getPlayers().size(); i++) {
			
			PlayerInterface player =  this.crossTable.getPlayers().getPlayers().get(i);
			
			System.out.println(String.format("Name: %d %s", player.getNumber(), player.getName()));		
		}
		
//		List<Integer> players =  this.crossTable.getPlayers().getListOfNumber();
//
//		for (int i = 0; i < this.crossTable.getRounds().getNumberOf(); i++) {
//			RoundInterface round =  this.crossTable.getRounds().Add();
//			
//		}
	}
		
	public  void WriteCrossTable() {
		this.output.WriteCrossTable(this.crossTable);
		
	  }
}
