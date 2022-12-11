package org.odusseus.pinakas.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.odusseus.pinakas.Interface.OutPutInterface;
import org.odusseus.pinakas.Interface.ParingInterface;
import org.odusseus.pinakas.Interface.PlayerInterface;
import org.odusseus.pinakas.Interface.PlayersInterface;
import org.odusseus.pinakas.Interface.RoundsInterface;

public class OutPut implements OutPutInterface {
	
	//@Override
	public void WriteCrossTable(PlayersInterface players, RoundsInterface rounds) {
		
        Iterable<PlayerInterface> iterable = players.getPlayers();
		
        List<String> lines = new ArrayList<String>(); 
        
        String lineSeparate = "_".repeat(1+((players.getFieldLenght()+1)*(players.size()+2)));
        
        lines.add( lineSeparate);
        
        String name = "Name"+ " ".repeat(players.getFieldLenght()-4);        
        String line = "|"+name +"|";
        
		for (PlayerInterface player : iterable) {
		   line += player.getName() + " ".repeat(players.getFieldLenght()-player.getName().length());
		   line += "|";		   
		}
		 String totaal = "Totaal"+ " ".repeat(players.getFieldLenght()-6);        
	      line += totaal +"|";
	        
		lines.add(line);
		
		 lines.add( lineSeparate);

		 line = "";
		 for (PlayerInterface player : iterable) {
			 line = "|";		   
			 line += player.getName()+ " ".repeat(players.getFieldLenght()-player.getName().length());
			 line += "|";	
			 for(int i = 0; i < players.size()+ 1 ; i++) {
			   line += " ".repeat(players.getFieldLenght());
			   line += "|";	
			 }
			 lines.add(line);
			 lines.add( lineSeparate);

			}
		 
		 //lines.add( "_".repeat(players.getFieldLenght()*players.getPlayers().size()+2));
		 
		for(String currentLine : lines) {
			System.out.println(currentLine);
		}
	}

}
