package com.mkyong.common;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mkyong.stock.Stock;
import com.mkyong.util.HibernateUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testStockName()
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	List<Stock> stocks = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			stocks = (List<Stock>) session.createQuery("from Stock").list();			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
        assertEquals(stocks.get(0).getStockName(), "PADINI");
    }
    
    public void testStockCode() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	List<Stock> stocks = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			stocks = (List<Stock>) session.createQuery("from Stock").list();			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
        assertEquals(stocks.get(0).getStockCode(), "7052");
    }
}
