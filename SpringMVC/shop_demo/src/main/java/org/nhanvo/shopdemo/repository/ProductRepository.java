package org.nhanvo.shopdemo.repository;

import java.util.Collection;

import org.nhanvo.shopdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
	public default Product getProductById(Long id) {
		return findOne(id);
	}
	
	public default Collection<Product> getAllProducts() {
		return findAll();
	}
	
	public default Product saveProduct(Product product) {
		return save(product);
	}
	
	public default void deleteProduct(Product product) {
		delete(product);
	}
}
