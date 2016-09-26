package org.nhanvo.shopdemo.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.nhanvo.shopdemo.model.Address;
import org.nhanvo.shopdemo.model.Product;
import org.nhanvo.shopdemo.model.Role;
import org.nhanvo.shopdemo.model.Shop;
import org.nhanvo.shopdemo.model.User;
import org.nhanvo.shopdemo.repository.ProductRepository;
import org.nhanvo.shopdemo.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author nhanvo Home controller class
 */
@Controller
public class HomeController {
	/**
	 * Mapping to http://localhost:8080/
	 * 
	 * @return Home page
	 */
	@RequestMapping("/")
	public String getHomePage() {
		return "home";
	}

	@RequestMapping(value = "/userinformation", method = RequestMethod.GET)
	public String getIndexPage() {
		return "UserInformation";
	}
	
	@Autowired
	ShopRepository shopDao;
	
	@Autowired
	ProductRepository productDao;
	
	@RequestMapping(value = "/testOneToOne", method = RequestMethod.GET)
	public String testOneToOne() {
		Shop shop = new Shop("Flower Shop");
		Address address = new Address(shop, "63 Nguyen Tat Thanh");
		
		shop.setAddress(address);
		shopDao.save(shop);
		return "ShopAddress";
	}
	
	@RequestMapping(value = "/testOneToMany", method = RequestMethod.GET)
	public String testOneToMany() {
		Shop shop = new Shop("Flower Shop");
		Address address = new Address(shop, "63 Nguyen Tat Thanh");
		
		shop.setAddress(address);
		shopDao.save(shop);
		
		Product product = new Product("Flower1", "Flower1.png", "This is beatyful flower", new Date(), new Date());
		product.setShop(shop);
		shop.getProductSet().add(product);
		
		productDao.saveProduct(product);
		return "ShopProduct";
	}
	
	@RequestMapping(value = "/testManyToMany", method = RequestMethod.GET)
	public String testManyToMany() {
		Shop shop = new Shop("Flower Shop 2");
		Address address = new Address(shop, "64 Nguyen Tat Thanh");
		
		shop.setAddress(address);
		shopDao.save(shop);
		
		Product product = new Product("Flower1", "Flower1.png", "This is beatyful flower", new Date(), new Date());
		product.setShop(shop);
		shop.getProductSet().add(product);
		
		User user1 = new User("vothanhnhan.it@gmail.com", "$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C", Role.USER, "nhanvt");
		User user2 = new User("vovanthi.it@gmail.com", "$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C", Role.USER, "thivv");
		
		Set<User> users = new HashSet<User>();
		users.add(user1);
		users.add(user2);
		
		product.setUsers(users);
		
		productDao.saveProduct(product);
		return "ProductUser";
	}
}
