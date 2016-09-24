package shopmanager.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shopmanager.models.Address;
import shopmanager.models.Product;
import shopmanager.models.Shop;
import shopmanager.repository.ProductDao;
import shopmanager.repository.ShopDao;

@Controller
public class MainController {

	@Autowired
	private ShopDao stockDao;
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String index() {
		return "home";
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String create(String email, String name) {
		try {
			Shop shop = new Shop();
			shop.setShopName("Flower Shop");

			Address address = new Address();
			address.setAddressName("63-NguyenTatThanh-HoiAn-QuangNam");
			
			shop.setAddress(address);			
			address.setShop(shop);
			
			Product p1, p2;
			p1 = new Product();
			p2 = new Product();			
			
			p1.setProductName("Hoa Hong");
			p1.setProductCreatedAt(new Date());
			p1.setProductDesc("This is flower for love");
			p1.setProductImage("image/rose.png");
			p1.setProductPrice("10 $");
			p1.setShop(shop);
			p1.setProductUpdateAt(new Date());
			
			p2.setProductName("Hoa Cuc");
			p2.setProductCreatedAt(new Date());
			p2.setProductDesc("This is flower for parent");
			p2.setProductImage("image/chrysanthemum.png");
			p2.setProductPrice("12 $");
			p2.setShop(shop);
			p2.setProductUpdateAt(new Date());

			shop.getProductSet().add(p1);
			shop.getProductSet().add(p2);
			stockDao.save(shop);
			productDao.save(p1);
			productDao.save(p2);
			
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Shop succesfully saved!";
	}

}
