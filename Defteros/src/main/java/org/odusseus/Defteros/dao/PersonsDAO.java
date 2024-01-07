package org.odusseus.Defteros.dao;

import org.odusseus.Defteros.entity.Person;
import org.odusseus.Defteros.entity.Persons;

public class PersonsDAO extends EntitiesDAO<Person, Persons>{

	public PersonsDAO(){
		super(Persons.class);
	}

	// public Persons read() {
	// 	Gson gson = new Gson();
  //   String jsonArray;
	// 	Persons persons = new Persons();		

		
	// 		File file = new File(persons.getFilename());
	// 		boolean isExist = file.exists();  // Check for valid path
	// 		boolean isFile  = file.isFile();  // Check for file
	// 		if(isExist && isFile) {
	// 			System.out.println("File is present");
  //   		try (FileInputStream fis = new FileInputStream(persons.getFilename())) {
	// 				DataInputStream reader = new DataInputStream(fis);
	// 				jsonArray = reader.readUTF();
	// 				reader.close();
	// 				persons = gson.fromJson(jsonArray,  Persons.class);		
	// 			} catch (IOException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
	// 	return persons;
	// }


	// public void save(Persons persons) {		
	// 	Gson gson = new Gson();
  //   String jsonArray = gson.toJson(persons);

	// 	try (FileOutputStream fos = new FileOutputStream(persons.getFilename())) {
	// 		DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
	// 		outStream.writeUTF(jsonArray);
	// 		outStream.close();
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}
  //   return;
	// }
	
	// public void savePerson(Person person) {
	// 	Persons persons = this.read();

	// 	persons.add(person);

	// 	this.save(persons);
	// }

	// public void delete(Integer id){
	// 	Persons persons = this.read();

	// 	persons.delete(id);

	// 	this.save(persons);

	// 	return;
	// };

	// public void updatePerson(Person person) {
	// 	Persons persons = this.read();

	// 	persons.update(person);

	// 	this.save(persons);
	// }
}
