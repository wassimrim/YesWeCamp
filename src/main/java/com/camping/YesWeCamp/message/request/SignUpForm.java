package com.camping.YesWeCamp.message.request;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.*;
 
public class SignUpForm {
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
 
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastname;
    
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;
 
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    
    private Set<String> roles;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
    @NotBlank
    @Size(min = 6, max = 40)
	private String number;
    
   
	private LocalDate birthDay;
    
    @NotBlank
	private String image;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRoles() {
      return this.roles;
    }
    
    public void setRoles(Set<String> roles) {
      this.roles = roles;
    }

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    
    
}