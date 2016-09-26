package org.nhanvo.shopdemo.repository;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.nhanvo.shopdemo.model.Shop;

@Repository
@Transactional
public class ShopRepository {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	public void save(Shop shop) {
		getSession().save(shop);
		return;
	}

	public void delete(Shop shop) {
		getSession().delete(shop);
		return;
	}

}
