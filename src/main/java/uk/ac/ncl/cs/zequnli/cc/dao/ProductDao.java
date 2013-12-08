package uk.ac.ncl.cs.zequnli.cc.dao;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import uk.ac.ncl.cs.zequnli.cc.model.Product;

import java.util.Iterator;

/**
 * @Auther: Li Zequn
 * Date: 08/12/13
 */
public interface ProductDao {
    Iterator<Product> getAllProduct() throws StorageException;
    void add(Product product) throws StorageException;
}
