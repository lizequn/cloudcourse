package uk.ac.ncl.cs.zequnli.cc.dao.impl;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.table.client.CloudTableClient;
import com.microsoft.windowsazure.services.table.client.TableOperation;
import com.microsoft.windowsazure.services.table.client.TableQuery;
import org.springframework.stereotype.Repository;
import uk.ac.ncl.cs.zequnli.cc.dao.ProductDao;
import uk.ac.ncl.cs.zequnli.cc.model.Customer;
import uk.ac.ncl.cs.zequnli.cc.model.Product;
import uk.ac.ncl.cs.zequnli.cc.util.TableStorage;

import java.util.Iterator;
import java.util.List;

/**
 * @Auther: Li Zequn
 * Date: 08/12/13
 */
@Repository
public class ProductDaoImpl implements ProductDao {
    @Override
    public void add(Product product) throws StorageException {
        TableOperation operation =  TableOperation.insert(product);
        CloudTableClient tableClient = TableStorage.getTableClient();
        tableClient.execute(TableStorage.TABLE_PRODUCT,operation);
    }

    @Override
    public Iterator<Product> getAllProduct() {
        CloudTableClient tableClient = TableStorage.getTableClient();
        TableQuery<Product> query = TableQuery.from(TableStorage.TABLE_PRODUCT,Product.class);
        return tableClient.execute(query).iterator();
    }
}
