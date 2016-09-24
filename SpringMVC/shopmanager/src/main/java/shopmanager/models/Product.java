package shopmanager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID", nullable = false, unique = true)
	private long productId;

	@Column(name = "PRODUCT_NAME", nullable = false, unique = true)
	private String productName;

	@Column(name = "PRODUCT_IMAGE", nullable = false, unique = true)
	private String productImage;

	@Column(name = "PRODUCT_DESC", nullable = false, unique = true)
	private String productDesc;

	@Column(name = "PRODUCT_PRICE", nullable = false, unique = true)
	private String productPrice;

	@Column(name = "PRODUCT_CREATEAT", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date productCreatedAt;

	@Column(name = "PRODUCT_UPDATEAT", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date productUpdateAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOP_ID", nullable = false)
	private Shop shop;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductCreatedAt() {
		return productCreatedAt;
	}

	public void setProductCreatedAt(Date productCreatedAt) {
		this.productCreatedAt = productCreatedAt;
	}

	public Date getProductUpdateAt() {
		return productUpdateAt;
	}

	public void setProductUpdateAt(Date productUpdateAt) {
		this.productUpdateAt = productUpdateAt;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}	
}
