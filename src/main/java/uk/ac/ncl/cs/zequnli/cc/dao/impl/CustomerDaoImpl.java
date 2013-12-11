package uk.ac.ncl.cs.zequnli.cc.dao.impl;

import java.net.URISyntaxException;
import java.util.Iterator;

import com.microsoft.windowsazure.services.table.client.*;
import uk.ac.ncl.cs.zequnli.cc.util.TableStorage;
import com.microsoft.windowsazure.services.core.storage.StorageException;
import org.springframework.stereotype.Repository;
import uk.ac.ncl.cs.zequnli.cc.dao.CustomerDao;
import uk.ac.ncl.cs.zequnli.cc.model.Customer;

/**
 * @Auther: Li Zequn
 * Date: 04/12/13
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean checkEmailAlreadyExist(String email) {
        CloudTableClient tableClient = TableStorage.getTableClient();
        String filter = TableQuery.generateFilterCondition(
                TableConstants.ROW_KEY,
                TableQuery.QueryComparisons.EQUAL,
                email);
        TableQuery<Customer> partitionQuery =
                TableQuery.from(TableStorage.TABLE_CUSTOMER, Customer.class)
                        .where(filter);
        return tableClient.execute(partitionQuery).iterator().hasNext();

    }

    @Override
    public void register(Customer customer) throws StorageException {
        TableOperation operation =  TableOperation.insert(customer);
        CloudTableClient tableClient = TableStorage.getTableClient();
        tableClient.execute(TableStorage.TABLE_CUSTOMER,operation);
    }


    @Override
    public Customer checkLogin(String country,String email,String password) throws StorageException {
        CloudTableClient tableClient = TableStorage.getTableClient();
        TableOperation operation =
                TableOperation.retrieve(country, email, Customer.class);
        Customer customer = tableClient.execute(TableStorage.TABLE_CUSTOMER,operation).getResultAsType();
        if(null == customer){
            return null;
        }
        if(customer.getPassword().equals(password)){
            return customer;
        }
        return null;
    }

    @Override
    public Iterator<Customer> getCustomers() {
        CloudTableClient tableClient = TableStorage.getTableClient();
        TableQuery<Customer> query = TableQuery.from(TableStorage.TABLE_CUSTOMER,Customer.class);
        return tableClient.execute(query).iterator();
    }

    @Override
    public Customer getCustomerByEmailCountry(String Country, String email) throws URISyntaxException, StorageException {
        CloudTableClient tableClient = TableStorage.getTableClient();
        TableOperation retrieveOperation = TableOperation.retrieve(Country, email,Customer.class);
        Customer customer = tableClient.execute(TableStorage.TABLE_CUSTOMER,retrieveOperation).getResultAsType();
        return customer;
    }
}
