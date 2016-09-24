package shopmanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private long id;

	@NotNull
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	// Password, will be hash code
	@NotNull
	@Column(name = "password_hash", nullable = false)
	private String password;

	@NotNull
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)	
	private Role role;

	@NotNull
	@Column(name = "firstname", nullable = false)
	private String firstname;

	@NotNull
	@Column(name = "lastname", nullable = false)
	private String lastname;

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return password;
	}

	public void setPassword(String passwordHash) {
		this.password = passwordHash;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", email='" + email.replaceFirst("@.*", "@***") + ", passwordHash='"
				+ password.substring(0, 10) + ", role=" + role + ", firstname=" + firstname + ", lastname="
				+ lastname + '}';
	}

}
