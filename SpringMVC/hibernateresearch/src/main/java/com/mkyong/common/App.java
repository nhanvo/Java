package com.mkyong.common;

import org.hibernate.Session;

import com.mkyong.onetoone.*;
import com.mkyong.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
//        Stock stock = new Stock();
//        
//        stock.setStockCode("4715");
//        stock.setStockName("GENM");
//        
//        session.save(stock);
//        session.getTransaction().commit();
        
//        Person person = new Person();
//        session.save( person );
//
//        Phone phone = new Phone( "123-456-7890" );
//        phone.setPerson( person );
//        session.save( phone );
//
//        session.getTransaction().commit();
        
//        Person person = new Person();
//        Phone phone1 = new Phone( "123-456-7890" );
//        Phone phone2 = new Phone( "321-654-0987" );
//
//        person.getPhones().add( phone1 );
//        person.getPhones().add( phone2 );
//        session.save(person );
//        session.getTransaction().commit();
        
        Phone phone = new Phone( "123-456-7890" );
        PhoneDetails details = new PhoneDetails( "T-Mobile", "GSM" );

        phone.addDetails( details );
        session.save( phone );
    }
}
