package com.mkyong;


import java.util.Date;
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDailyRecord;
import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (XML Mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Stock stock = new Stock();
        stock.setStockCode("7052");
        stock.setStockName("PADINI");
        session.save(stock);
        
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(new Date());
        
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);

        session.save(stockDailyRecords);
        
        session.getTransaction().commit();
		System.out.println("Done");
		
		listStock(session);
	}
	
	/* Method to  READ all the employees */
	public static void listStock(Session session) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<Stock> stocks = (List<Stock>) session.createQuery("from Stock").list();
			for (Iterator iterator = stocks.iterator(); iterator.hasNext();) {
				Stock stock = (Stock) iterator.next();
				System.out.print("Stock Code: " + stock.getStockCode());
				System.out.print(" Stock Name: " + stock.getStockName());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
