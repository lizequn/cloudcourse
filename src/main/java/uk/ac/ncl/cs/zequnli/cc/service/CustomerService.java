package uk.ac.ncl.cs.zequnli.cc.service;

import uk.ac.ncl.cs.zequnli.cc.model.Customer;

import java.util.Iterator;
import java.util.List;

/**
 * @Auther: Li Zequn
 * Date: 04/12/13
 */
public interface CustomerService {
    boolean login(String email,String password,String country);
    boolean register(Customer customer);
    Iterator<Customer> listCustomer();
}
