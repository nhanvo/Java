package org.nhanvo.shopdemo.model;
 
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author nhanvo
 * Product POJO class, mapping data to object from database by Hibernate
 */
@Entity
@Table(name = "product")
public class Product {
	// Automatic generate
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
	
	// Title of product
	@Column(name="name", nullable = false)
	private String name;
	
	// Author of product
	@Column(name="image", nullable = false)	
	private String image;
	
	// Description of product
	@Column(name="description", nullable = false)	
	private String description;	
	
	// Date created of product
	@Column(name="createdat", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	// Date updated of product
	@Column(name="updateat", nullable = false)	
	@Temporal(TemporalType.DATE)
	private Date updateAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOP_ID", nullable = false)
	private Shop shop;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "product_user", joinColumns = { 
			@JoinColumn(name = "PRODUCT_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "USER_ID", 
					nullable = false, updatable = false) })
	private Set<User> users = new HashSet<User>(0);
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Product() {
	}

	public Product(String name, String image, String description, Date createdAt, Date updateAt) {
		super();
		this.name = name;
		this.image = image;
		this.description = description;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Long getId() {
		return id;
	}	
	//=========================================================================
}
