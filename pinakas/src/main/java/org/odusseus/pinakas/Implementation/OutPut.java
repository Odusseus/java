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
        
        lines.add( "_".repeat(players.getFieldLenght()*players.getPlayers().size()+2));
        
        String name = "Name"+ " ".repeat(players.getFieldLenght()-4);
        
        
        String line = "|"+name +"|";
		for (PlayerInterface player : iterable) {
		   line += player.getName();
		   line += "|";		   
		}
		lines.add(line);
		 lines.add( "_".repeat(players.getFieldLenght()*players.getPlayers().size()+2));

		 line = "";
		 for (PlayerInterface player : iterable) {
			 line = "|";		   
			 line += player.getName()+ " ".repeat(players.getFieldLenght()-player.getName().length());
			 line += "|";	
			 lines.add(line);
			}
		 
		 lines.add( "_".repeat(players.getFieldLenght()*players.getPlayers().size()+2));
		 
		for(String currentLine : lines) {
			System.out.println(currentLine);
		}
	}

}
