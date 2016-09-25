package org.nhanvo.shopdemo.controller.product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.nhanvo.shopdemo.controller.user.LoginController;
import org.nhanvo.shopdemo.model.Product;
import org.nhanvo.shopdemo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author nhanvo Product controller class
 */
@Controller
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// Mapping to model when user access url param /product/{id}
	@RequestMapping("/product/{id}")
	public ModelAndView getProductPage(@PathVariable Long id) {
		return new ModelAndView("product_details", "product", productService.getProductById(id)
				.orElseThrow(() -> new NoSuchElementException(String.format("Product=%s not found", id))));
	}

	// Mapping to model when user access url param /product/{id}
	@RequestMapping(value = "/product/create", method = RequestMethod.GET)
	public ModelAndView getUserCreatePage() {
		return new ModelAndView("product_create", "form", new Product());
	}

	@RequestMapping(value = "/product/create", method = RequestMethod.POST)
	public String handleProductCreateForm(@ModelAttribute("createProductForm") Product product,
			@ModelAttribute("createdat") String createdat, @ModelAttribute("updateat") String updateat,
			BindingResult bindingResult) {
		// failed validation
		if (bindingResult.hasErrors()) {
			return "product_create";
		}

		// Convert String to sql.Date
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			product.setCreatedAt(formatter.parse(createdat));
			product.setUpdateAt(formatter.parse(updateat));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Create product
		try {
			productService.createProduct(product);
		} catch (DataIntegrityViolationException e) {
			return "product_create";
		}
		// ok, redirect
		return "redirect:/products";
	}

	@RequestMapping(value = "/product/edit/{id}", method = RequestMethod.GET)
	public ModelAndView getUserEditPage(@PathVariable Long id) {
		return new ModelAndView("product_edit", "product", productService.getProductById(id)
				.orElseThrow(() -> new NoSuchElementException(String.format("Product=%s not found", id))));
	}

	@RequestMapping(value = "/product/edit/{id}", method = RequestMethod.POST)
	public String handleProductEditForm(@Valid @ModelAttribute("editProductForm") Product product,
			@ModelAttribute("createdat") String createdat, @ModelAttribute("updateat") String updateat,
			@PathVariable Long id, BindingResult bindingResult) {
		// failed validation
		if (bindingResult.hasErrors()) {
			return "product_edit";
		}

		// Convert String to sql.Date
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			product.setCreatedAt(formatter.parse(createdat));
			product.setUpdateAt(formatter.parse(updateat));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			productService.editProduct(product, id);
		} catch (DataIntegrityViolationException e) {
			return "product_edit";
		}
		// successful, redirect
		return "redirect:/products";
	}

	@RequestMapping(value = { "/product/delete/{id}" })
	public String handleProductDeleteForm(@PathVariable Long id) {
		try {
			productService.deleteProduct(id);
		} catch (DataIntegrityViolationException e) {
			return "redirect:/products";
		}
		// successful, redirect
		return "redirect:/products";
	}

	/**
	 * Mapping http://localhost:8080/products
	 * 
	 * @return Model and view of all products
	 */
	@RequestMapping("/products")
	public ModelAndView getProductsPage() {
		return new ModelAndView("products", "products", productService.getAllProducts());
	}
}
