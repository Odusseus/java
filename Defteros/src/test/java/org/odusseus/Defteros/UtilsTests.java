package org.odusseus.Defteros;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.odusseus.Defteros.entity.Event;
import org.odusseus.Defteros.utils.Utils;

@SpringBootTest
public class UtilsTests {
  
  @Test
  public void getShortClassName_Return_True_Test(){
    Event event = new Event();
    String assertName = Utils.getShortClassName(event);
    assertTrue( assertName.equals("Event"));
  }

  @Test
  public void getShortClassName_Return_False_Test(){
    Event event = new Event();
    String assertName = Utils.getShortClassName(event);
    assertTrue( assertName.equals("Event"));
  }

  @Test
  public void getBCryptPassword_Return_String_for_pascal(){
    String passwordString = "pascal";
    String assertBCryptPassword = Utils.getBCryptPassword(passwordString);
    assertNotNull(assertBCryptPassword);
    System.out.println("Password:" + passwordString + "/" + assertBCryptPassword);
  }

  @Test
  public void getBCryptPassword_Return_String_for_admin(){
    String passwordString = "admin";
    String assertBCryptPassword = Utils.getBCryptPassword(passwordString);
    assertNotNull(assertBCryptPassword);
    System.out.println("Password:" + passwordString + "/" + assertBCryptPassword); 
  }
}
