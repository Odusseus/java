package org.odusseus.Defteros;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.odusseus.Defteros.entity.Events;

import com.google.gson.*;

public class EventsDAO {
	private static final String fileName = "events.json";

	public Events read() {
		Gson gson = new Gson();
    String jsonArray;
		Events events = new Events();		

    try (FileInputStream fis = new FileInputStream(fileName)) {
			DataInputStream reader = new DataInputStream(fis);
			jsonArray = reader.readUTF();
			reader.close();
			
			events = gson.fromJson(jsonArray,  Events.class);		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
		return events;
	}

	public void save(Events events) {
		Gson gson = new Gson();
    String jsonArray = gson.toJson(events);

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
}
