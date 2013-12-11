package uk.ac.ncl.cs.zequnli.cc.dao.impl;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.table.client.CloudTableClient;
import com.microsoft.windowsazure.services.table.client.TableConstants;
import com.microsoft.windowsazure.services.table.client.TableOperation;
import com.microsoft.windowsazure.services.table.client.TableQuery;
import org.springframework.stereotype.Repository;
import uk.ac.ncl.cs.zequnli.cc.dao.OrderDao;
import uk.ac.ncl.cs.zequnli.cc.model.Customer;
import uk.ac.ncl.cs.zequnli.cc.model.Order;
import uk.ac.ncl.cs.zequnli.cc.util.TableStorage;

import java.util.HashMap;
import java.util.Iterator;
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

    @Override
    public Map<String, Double> getTotalOrderByCountry(String countryName) {
        long i = 0;
//        System.out.println(countryName);
        CloudTableClient tableClient = TableStorage.getTableClient();
        String filter = TableQuery.generateFilterCondition(
                TableConstants.PARTITION_KEY,
                TableQuery.QueryComparisons.EQUAL,
                countryName);
        TableQuery<Order> partitionQuery =
                TableQuery.from(TableStorage.TABLE_ORDER, Order.class)
                        .where(filter);
        Iterator<Order> iterator = tableClient.execute(partitionQuery).iterator();
        Map<String,Double> map = new HashMap<String, Double>();
        Order order;

        while (iterator.hasNext()){
           // order = iterator.next();
//            System.out.println(order.getEmail());
            order = iterator.next();
            if(map.containsKey(order.getEmail())){
                map.put(order.getEmail(),map.get(order.getEmail())+order.getPrice());
            } else {
                map.put(order.getEmail(),order.getPrice());
            }
            i++;
        }
       // System.out.println("total num:" +map.size());
        return map;
    }

    @Override
    public Long getTotalNum() {
        long i =0;
        CloudTableClient tableClient = TableStorage.getTableClient();
        TableQuery<Order> partitionQuery =
                TableQuery.from(TableStorage.TABLE_ORDER, Order.class);
        Iterator<Order> iterator = tableClient.execute(partitionQuery).iterator();
        while(iterator.hasNext()){
            iterator.next();
            i++;
        }
        return i;
    }
}
