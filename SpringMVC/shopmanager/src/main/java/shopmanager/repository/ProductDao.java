package shopmanager.repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shopmanager.models.Product;

@Repository
@Transactional
public class ProductDao {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	public void save(Product product) {
		getSession().save(product);
		return;
	}

	public void delete(Product product) {
		getSession().delete(product);
		return;
	}

}