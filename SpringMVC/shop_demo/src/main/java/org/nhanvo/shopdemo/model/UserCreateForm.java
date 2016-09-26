package org.nhanvo.shopdemo.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author nhanvo
 * Create new user form class
 */
public class UserCreateForm {
	
	@NotEmpty
	private Long Id;
	
	// Email
    @NotEmpty
    private String email = "";

    // Password
    @NotEmpty
    private String password = "";

    // Password repeat
    @NotEmpty
    private String passwordRepeated = "";

    // Role
    @NotNull
    private Role role = Role.USER;

    // First name
    @NotEmpty
    private String username = "";
    
	public UserCreateForm() {
	}

	public UserCreateForm(Long Id, String email, Role role, String username) {
		this.Id = Id;
		this.email = email;
		this.role = role;
		this.username = username;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
