package org.odusseus.Defteros.entity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Users extends BaseEntities<User>{
    
    public boolean hasExistsIgnoreCase(String name)
    {
        if(name.equalsIgnoreCase("ADMIN")) return true;
        return super.hasExistsIgnoreCase(name);
    }
}