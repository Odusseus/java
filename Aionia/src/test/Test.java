package test;

import static org.junit.jupiter.api.Assertions.*;

import aionia.ISay;
import aionia.Say;

class Test {

  @org.junit.jupiter.api.Test
  void test() {
    ISay say = new Say();
    
    say.Hello();
    assertTrue(true);
  }

}
