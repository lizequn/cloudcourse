package uk.ac.ncl.cs.zequnli.cc.dao;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import uk.ac.ncl.cs.zequnli.cc.model.Order;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Li Zequn
 * Date: 09/12/13
 */
public interface OrderDao {
    void createOrder(Order order) throws StorageException;
    Map<String,Double> getTotalOrderByCountry(String countryName);
    Long getTotalNum();
    Iterator<Order> getAllOrders();

}
