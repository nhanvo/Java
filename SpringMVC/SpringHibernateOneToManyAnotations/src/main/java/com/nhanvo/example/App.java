package com.nhanvo.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import com.nhanvo.example.stock.Stock;
import com.nhanvo.example.stock.StockDailyRecord;
import com.nhanvo.example.util.HibernateUtil;

public class App {
	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static void main( String[] args )
    {
    	System.out.println("Hibernate one to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
        stock.setStockCode("7053");
        stock.setStockName("NHANVO");
        session.save(stock);
        
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.5"));
        stockDailyRecords.setPriceClose(new Float("1.7"));
        stockDailyRecords.setPriceChange(new Float("10.8"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(parseDate("2014-02-14"));
        
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);

        session.save(stockDailyRecords);

		session.getTransaction().commit();
		System.out.println("Done");
	}
}
