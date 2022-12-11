package org.odusseus.pinakas.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.odusseus.pinakas.Interface.CrossTableInterface;
import org.odusseus.pinakas.Interface.OutPutInterface;
import org.odusseus.pinakas.Interface.ParingInterface;
import org.odusseus.pinakas.Interface.PlayerInterface;
import org.odusseus.pinakas.Interface.PlayersInterface;
import org.odusseus.pinakas.Interface.RoundsInterface;

public class OutPut implements OutPutInterface {
	
	//@Override
	public void WriteCrossTable(CrossTableInterface crossTable) {
		
        Iterable<PlayerInterface> iterable = crossTable.getPlayers().getPlayers();
		
        List<String> lines = new ArrayList<String>(); 
        
        String lineSeparate = "_".repeat(1+((crossTable.getPlayers().getFieldLenght()+1)*(crossTable.getPlayers().getPlayers().size()+2)));
        
        lines.add( lineSeparate);
        
        String name = "Name"+ " ".repeat(crossTable.getPlayers().getFieldLenght()-4);        
        String line = "|"+name +"|";
        
		for (PlayerInterface player : iterable) {
		   line += player.getName() + " ".repeat(crossTable.getPlayers().getFieldLenght()-player.getName().length());
		   line += "|";		   
		}
		 String totaal = "Totaal"+ " ".repeat(crossTable.getPlayers().getFieldLenght()-6);        
	      line += totaal +"|";
	        
		lines.add(line);
		
		 lines.add( lineSeparate);

		 line = "";
		 for (PlayerInterface player : iterable) {
			 line = "|";		   
			 line += player.getName()+ " ".repeat(crossTable.getPlayers().getFieldLenght()-player.getName().length());
			 line += "|";	
			 for(int i = 0; i < crossTable.getPlayers().size()+ 1 ; i++) {
			   line += " ".repeat(crossTable.getPlayers().getFieldLenght());
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
