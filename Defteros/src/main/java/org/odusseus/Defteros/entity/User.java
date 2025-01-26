package org.odusseus.Defteros.entity;

import org.odusseus.Defteros.utils.Utils;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class User extends BaseEntity{
	
	@NotNull(message = "Password cannot be empty.")
	private String password;
	
	private String passwordEncrypted;

	@NotNull(message = "Roletype cannot be empty.")
    private RoleType roleType;

	public User(String name, String password, RoleType roleType) {
		super();		
		this.name = name;
		this.password = password;		
		this.passwordEncrypted = Utils.getBCryptPassword(password);
		this.roleType = roleType;
	}		
}
