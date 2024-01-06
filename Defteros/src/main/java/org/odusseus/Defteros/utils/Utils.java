package org.odusseus.Defteros.utils;

public final class Utils {

  public static <T> String getShortClassName(T t){
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
