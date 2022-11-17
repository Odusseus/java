package test;

import static org.junit.jupiter.api.Assertions.*;

import aionia.Say;

class Test {

  @org.junit.jupiter.api.Test
  void test() {
    Say say = new Say();
    
    say.Hello();
    assertTrue(true);
  }

}
