package netgloo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import shopmanager.models.Address;
import shopmanager.models.Shop;
import shopmanager.repository.ShopDao;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	ShopDao shopDao;
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
    public void testShopAddressOneToOne()
    {
    	Address address = new Address();
    	address.setAddressName("63-NguyenTatThanh");
    	
    	Shop shop = new Shop();
    	shop.setShopName("Flower Shop");
    	shop.setAddress(address);
    	
    	shopDao.save(shop);
    	
        assertTrue(true);
    }
}
