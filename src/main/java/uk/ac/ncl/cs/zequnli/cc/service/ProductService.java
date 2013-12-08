package uk.ac.ncl.cs.zequnli.cc.service;

import uk.ac.ncl.cs.zequnli.cc.model.Product;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Li Zequn
 * Date: 08/12/13
 */
public interface ProductService {
    Map<String,Product> getAllProductMap();
    List<Product> getAllProduct();
}
