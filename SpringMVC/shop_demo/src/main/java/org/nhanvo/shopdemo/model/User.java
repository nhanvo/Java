package org.nhanvo.shopdemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * 
 * @author nhanvo
 * User POJO class, mapping data to object from database by Hibernate
 */
@Entity
@Table(name = "user")
public class User {

	// User Id, auto generate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false, updatable = false)
    private Long id;

    // Email
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    // Password, will be hash code 
    @Column(name = "PASSWORD", nullable = false)
    private String passwordHash;

    // Role
    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    // First name
    @Column(name = "USERNAME", nullable = false)
    private String username;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Product> products = new HashSet<Product>(0);
    
    public User() {
	}

	public User(String email, String passwordHash, Role role, String username) {
		super();
		this.email = email;
		this.passwordHash = passwordHash;
		this.role = role;
		this.username = username;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
