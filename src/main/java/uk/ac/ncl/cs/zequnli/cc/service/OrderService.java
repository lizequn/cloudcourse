package uk.ac.ncl.cs.zequnli.cc.service;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import uk.ac.ncl.cs.zequnli.cc.model.Customer;
import uk.ac.ncl.cs.zequnli.cc.model.Order;

import java.net.URISyntaxException;
import java.util.Map;

/**
 * @Auther: Li Zequn
 * Date: 09/12/13
 */
public interface OrderService {
    boolean createOrder(Order order);
    Map<Customer,Double> getTotalOrderByCountry(String country) throws URISyntaxException, StorageException;
    Long getTotalOrder();

}
