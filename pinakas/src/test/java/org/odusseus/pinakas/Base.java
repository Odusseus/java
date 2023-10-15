package org.odusseus.pinakas.Implementation;

import java.util.Arrays;
import java.util.List;

class Test {
	
	@org.junit.jupiter.api.Test
    void getNamesTest() {
	  String names = this.properties.getProperty("names");
	  List<String> nameList = Arrays.asList(names.split("\\s*,\\s*"));
	
	  
	  
	  return nameList;
}

}