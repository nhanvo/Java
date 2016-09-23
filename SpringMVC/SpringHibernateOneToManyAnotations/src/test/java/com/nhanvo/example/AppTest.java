package com.nhanvo.example;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nhanvo.example.stock.Stock;
import com.nhanvo.example.util.HibernateUtil;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	private List<Stock> stocks = null;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
       Session session = HibernateUtil.getSessionFactory().openSession();
        	
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
        assertEquals(stocks.get(1).getStockName(), "NHANVO");
    }
    
    public void testStockCode() {
        assertEquals(stocks.get(1).getStockCode(), "7053");
    }
}
