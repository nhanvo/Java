package org.nhanvo.shopdemo.service;

import java.util.Collection;
import java.util.Optional;

import org.nhanvo.shopdemo.model.Product;

/**
 * 
 * @author nhanvo
 * product service interface
 */
public interface ProductService {
	/**
	 * Get product by Id
	 * @param id Input id
	 * @return Return product object found
	 */
	public Optional<Product> getProductById(Long id);
	
	
	/**
	 * Get all products
	 * @return List products object found
	 */
	Collection<Product> getAllProducts();
	
	/**
	 * Create new product
	 * @param form product create form
	 * @return product created
	 */
	Product createProduct(Product product);
	
	/**
	 * Edit information of product
	 * @param form product Edit form
	 * @param id Id of product edited
	 * @return product edited
	 */
	Product editProduct(Product product, Long id);
	
	/**
	 * Delete product
	 * @param id Id of product need delete
	 * @return Product deleted
	 */
	Boolean deleteProduct(Long id);
}
