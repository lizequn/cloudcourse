package uk.ac.ncl.cs.zequnli.cc.service.impl;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ncl.cs.zequnli.cc.dao.OrderDao;
import uk.ac.ncl.cs.zequnli.cc.model.Order;
import uk.ac.ncl.cs.zequnli.cc.service.OrderService;

/**
 * @Auther: Li Zequn
 * Date: 09/12/13
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
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
}
