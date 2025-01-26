package org.odusseus.Defteros.entity;

public enum RoleType {
    ADMIN("Admin"),
    USER("User");
    
    private final String displayValue;

    private RoleType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return this.displayValue;
    }

    // public static RoleType fromString(String text) {
    //     for(RoleType r : RoleType.values()){
    //       if (r.text.equalsIgnoreCase(text)) {
    //         return r;
    //       }
    //     }
    //     return null;
    // }
}
