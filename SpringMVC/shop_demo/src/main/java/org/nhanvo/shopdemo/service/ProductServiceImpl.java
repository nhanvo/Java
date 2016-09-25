package org.nhanvo.shopdemo.service;

import java.util.Collection;
import java.util.Optional;

import org.nhanvo.shopdemo.model.Product;
import org.nhanvo.shopdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author nhanvo
 * product service implement class
 * 
 */
@Service
public class ProductServiceImpl implements ProductService{
	// product repository
	private final ProductRepository productRepository;
	
	/**
	 * Constructor
	 * @param productRepository
	 */
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	/**
	 * Override from parent
	 */
	@Override
	public Optional<Product> getProductById(Long id) {
		return Optional.ofNullable(productRepository.getProductById(id));
	}

	/**
	 * Override from parent
	 */
	@Override
	public Collection<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}	

	/**
	 * Override from parent
	 */
	@Override
	public Product createProduct(Product product) {
		return productRepository.saveProduct(product);
	}

	/**
	 * Override from parent
	 */
	@Override
	public Product editProduct(Product product, Long id) {
		Product newProduct = productRepository.getProductById(id);		
		newProduct.setCreatedAt(product.getCreatedAt());
		newProduct.setDescription(product.getDescription());
		newProduct.setImage(product.getImage());
		newProduct.setName(product.getName());
		newProduct.setUpdateAt(product.getUpdateAt());
		return productRepository.saveProduct(newProduct);
	}

	/**
	 * Override from parent
	 */
	@Override
	public Boolean deleteProduct(Long id) {		
		Product product = productRepository.getProductById(id);
		if (product != null) {
			productRepository.deleteProduct(product);
			return true;
		}
		
		return false;
	}	
}
