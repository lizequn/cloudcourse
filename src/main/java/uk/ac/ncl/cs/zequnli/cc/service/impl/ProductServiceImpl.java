package uk.ac.ncl.cs.zequnli.cc.service.impl;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ncl.cs.zequnli.cc.dao.ProductDao;
import uk.ac.ncl.cs.zequnli.cc.model.Customer;
import uk.ac.ncl.cs.zequnli.cc.model.Product;
import uk.ac.ncl.cs.zequnli.cc.service.ProductService;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Auther: Li Zequn
 * Date: 08/12/13
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Map<String,Product> getAllProductMap() {
        Iterator<Product> iterator = null;
        try {
            iterator = productDao.getAllProduct();
        } catch (StorageException e) {
            e.printStackTrace();
            return null;
        }
        Map<String,Product> list= new HashMap<String, Product>();
        if(null == iterator)  return null;
        while(iterator.hasNext()){
            Product p = iterator.next();
            list.put(p.getRowKey(),p);
        }
        return list;
    }

    @Override
    public List<Product> getAllProduct() {
        Iterator<Product> iterator = null;
        try {
            iterator = productDao.getAllProduct();
        } catch (StorageException e) {
            e.printStackTrace();
            return null;
        }
        List<Product> list= new ArrayList<Product>();
        if(null == iterator)  return null;
        while(iterator.hasNext()){
            Product p = iterator.next();
            list.add(p);
        }
        return list;
    }
}
