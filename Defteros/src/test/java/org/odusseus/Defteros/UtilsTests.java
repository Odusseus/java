package org.odusseus.Defteros;

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
}
