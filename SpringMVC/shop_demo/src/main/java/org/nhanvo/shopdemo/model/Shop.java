package org.nhanvo.shopdemo.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SHOP_ID", unique = true, nullable = false)
	private Integer shopId;

	@Column(name = "SHOP_NAME", nullable = false, length = 20)
	private String shopName;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "shop", cascade = CascadeType.ALL)
	private Address address;

	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
	 private Set<Product> productSet = new HashSet<Product>(0);

	 public Set<Product> getProductSet() {
	 return productSet;
	 }
	
	 public void setProductSet(Set<Product> productSet) {
	 this.productSet = productSet;
	 }

	public Shop(String shopName) {
		this.shopName = shopName;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}