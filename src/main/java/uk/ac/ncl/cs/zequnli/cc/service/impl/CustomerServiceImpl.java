package uk.ac.ncl.cs.zequnli.cc.service.impl;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ncl.cs.zequnli.cc.dao.CustomerDao;
import uk.ac.ncl.cs.zequnli.cc.model.Customer;
import uk.ac.ncl.cs.zequnli.cc.service.CustomerService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: Li Zequn
 * Date: 04/12/13
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Iterator<Customer> listCustomer() {
//        Iterator<Customer> iterator = null;
//        try {
//            iterator = customerDao.getCustomers();
//        } catch (StorageException e) {
//            e.printStackTrace();
//            return null;
//        }
//        List<Customer> list= new ArrayList<Customer>();
//        if(null == iterator)  return null;
//        while(iterator.hasNext()){
//            list.add(iterator.next());
//        }
        try {
            return customerDao.getCustomers();
        } catch (StorageException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public boolean login(String email, String password, String country) {
        try {
            return customerDao.checkLogin(country,email,password);
        } catch (StorageException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean register(Customer customer) {
        try {
            if(customerDao.checkEmailAlreadyExist(customer.getRowKey()))   {
                return false;
            }
        } catch (StorageException e) {
            e.printStackTrace();
            return false;
        }
        try {
            customerDao.register(customer);
        } catch (StorageException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
