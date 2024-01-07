package org.odusseus.Defteros.dao;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.odusseus.Defteros.entity.BaseEntities;
import org.odusseus.Defteros.entity.BaseEntity;

import com.google.gson.*;

public class EntitiesDAO<T extends BaseEntity, U extends BaseEntities<T>>  {

	private Class<U> typeU;

	public EntitiesDAO(Class<U> typeU){
		this.typeU = typeU;
	}

	U createContents(Class<U> clazz) {
		try {
			return clazz.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public U read() {
		Gson gson = new Gson();
    String jsonArray;
		U baseEntities = this.createContents(typeU);		
		File file = new File(baseEntities.getFilename());
		boolean isExist = file.exists();  // Check for valid path
		boolean isFile  = file.isFile();  // Check for file
		if(isExist && isFile) {
			System.out.println("File is present");
   		try (FileInputStream fis = new FileInputStream(baseEntities.getFilename())) {
				DataInputStream reader = new DataInputStream(fis);
				jsonArray = reader.readUTF();
				reader.close();
				baseEntities = gson.fromJson(jsonArray,  this.typeU);		
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return baseEntities;
 }

	public void save(U baseEntities) {		
		Gson gson = new Gson();
    String jsonArray = gson.toJson(baseEntities);

		try (FileOutputStream fos = new FileOutputStream(baseEntities.getFilename())) {
			DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
			outStream.writeUTF(jsonArray);
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    return;
	}
	
	public void saveEntity(T baseEntity) {
		U baseEntities = this.read();

		baseEntities.add(baseEntity);

		this.save(baseEntities);
	}

	public void delete(Integer id){
		U baseEntities = this.read();

		baseEntities.delete(id);

		this.save(baseEntities);

		return;
	};

	public void updateEntity(T baseEntity) {
		U baseEntities = this.read();

		baseEntities.update(baseEntity);

		this.save(baseEntities);
	}
}
