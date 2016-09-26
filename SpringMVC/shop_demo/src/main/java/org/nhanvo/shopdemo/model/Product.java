package org.nhanvo.shopdemo.model;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	//=========================================================================
	// Get and Set function
	//=========================================================================

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
