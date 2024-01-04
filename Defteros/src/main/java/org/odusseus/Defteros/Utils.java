package org.odusseus.Defteros;

public final class Utils {

  public static <T> String GetShortClassName(T t){
    Class<?> enclosingClass = t.getClass().getEnclosingClass();
    String name;

    if (enclosingClass != null) {
      name = enclosingClass.getName();
    } else {
      name = t.getClass().getName();
    }

    String shortName = name.substring(name.lastIndexOf('.') + 1);
    return shortName;
  }
  
}
