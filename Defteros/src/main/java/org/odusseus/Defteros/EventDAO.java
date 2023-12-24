package org.odusseus.Defteros;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;


public class EventDAO {
	public List<Event> read() {
		Gson gson = new Gson();
    String jsonArray;
		String fileName = "event.json";
		List<Event> listEvent = new ArrayList<Event>();		

    try (FileInputStream fis = new FileInputStream(fileName)) {
			DataInputStream reader = new DataInputStream(fis);
			jsonArray = reader.readUTF();
			reader.close();
			
			listEvent = gson.fromJson(jsonArray,  ArrayList.class);		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
		return listEvent;
	}

	public void save(List<Event> listEvent) {
		Gson gson = new Gson();
    String jsonArray = gson.toJson(listEvent);
		String fileName = "event.json";

		try (FileOutputStream fos = new FileOutputStream(fileName)) {
			DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
			outStream.writeUTF(jsonArray);
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    return;
	}

	public void add(Event event) {
		
	}
}
