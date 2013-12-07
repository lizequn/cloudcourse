package uk.ac.ncl.cs.zequnli.cc.dao;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import uk.ac.ncl.cs.zequnli.cc.model.Customer;

import java.util.Iterator;

/**
 * @Auther: Li Zequn
 * Date: 04/12/13
 */
public interface CustomerDao {
    void register(Customer customer) throws StorageException;
    Customer checkLogin(String country,String email,String password) throws StorageException;
    boolean checkEmailAlreadyExist(String email) throws StorageException;
    Iterator<Customer> getCustomers() throws StorageException;


}
