package uk.ac.ncl.cs.zequnli.cc.service.impl;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ncl.cs.zequnli.cc.dao.CustomerDao;
import uk.ac.ncl.cs.zequnli.cc.dao.OrderDao;
import uk.ac.ncl.cs.zequnli.cc.model.Customer;
import uk.ac.ncl.cs.zequnli.cc.model.Order;
import uk.ac.ncl.cs.zequnli.cc.model.Order4CSV;
import uk.ac.ncl.cs.zequnli.cc.service.OrderService;

import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @Auther: Li Zequn
 * Date: 09/12/13
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean createOrder(Order order) {
        try {
            orderDao.createOrder(order);
        } catch (StorageException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Map<Customer, Double> getTotalOrderByCountry(String country) throws URISyntaxException, StorageException {
        Map<Customer,Double> map = new HashMap<Customer, Double>();
        Map<String,Double> map1 = orderDao.getTotalOrderByCountry(country);
        DecimalFormat df = new DecimalFormat("#.00");
        for(String s:map1.keySet()){

            map.put(customerDao.getCustomerByEmailCountry(country, s),Double.valueOf(df.format(map1.get(s))));
        }
        //System.out.println(map.size());
        return map;
    }

    @Override
    public Long getTotalOrder() {
        return orderDao.getTotalNum();
    }

    @Override
    public Iterator<Order4CSV> getAllOrder() {
        Iterator<Order> i =orderDao.getAllOrders();
        List<Order4CSV> list = new ArrayList<Order4CSV>();
        while (i.hasNext()){
            list.add(new Order4CSV(i.next()));
        }
        return list.iterator();
    }
}
