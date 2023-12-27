package org.odusseus.Defteros;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.odusseus.Defteros.entity.Event;
import org.odusseus.Defteros.entity.Events;

import com.google.gson.*;

public class EventsDAO {
	private static final String fileName = "events.json";

	public Events read() {
		Gson gson = new Gson();
    String jsonArray;
		Events events = new Events();		

		
			File file = new File(fileName);
			boolean isExist = file.exists();  // Check for valid path
			boolean isFile  = file.isFile();  // Check for file
			if(isExist && isFile) {
				System.out.println("File is present");
    		try (FileInputStream fis = new FileInputStream(fileName)) {
					DataInputStream reader = new DataInputStream(fis);
					jsonArray = reader.readUTF();
					reader.close();
					events = gson.fromJson(jsonArray,  Events.class);		
				} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return events;
	}

	public void saveEvent(Event event) {
		Events events = this.read();

		events.add(event);

		Gson gson = new Gson();
    String jsonArray = gson.toJson(events);

		try (FileOutputStream fos = new FileOutputStream(fileName)) {
			DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
			outStream.writeUTF(jsonArray);
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    return;
	}
}
