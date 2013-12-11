package uk.ac.ncl.cs.zequnli.cc.dao.impl;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.table.client.CloudTableClient;
import com.microsoft.windowsazure.services.table.client.TableOperation;
import org.springframework.stereotype.Repository;
import uk.ac.ncl.cs.zequnli.cc.dao.OrderDao;
import uk.ac.ncl.cs.zequnli.cc.model.Order;
import uk.ac.ncl.cs.zequnli.cc.util.TableStorage;

import java.util.Map;

/**
 * @Auther: Li Zequn
 * Date: 09/12/13
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Override
    public void createOrder(Order order) throws StorageException {
        TableOperation operation =  TableOperation.insert(order);
        CloudTableClient tableClient = TableStorage.getTableClient();
        tableClient.execute(TableStorage.TABLE_ORDER,operation);
    }

//    @Override
//    public Map<String, Integer> getTotalOrderByCountry(String countryName) {
//
//    }
}
