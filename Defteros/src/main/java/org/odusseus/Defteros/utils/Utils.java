package org.odusseus.Defteros.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

  public static <T> String getBCryptPassword(T t){
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode((String)t);
  }
  
}
