package uk.ac.ncl.cs.zequnli.cc.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Li Zequn
 * Date: 08/12/13
 */
public class ProductUtil {
    private static Map<String,String> list = null;
    public static  Map<String,String> getAllProducts(){
        if(null == list){
            list = new HashMap<String, String>();
            list.put("SKU0001","Product1");
            list.put("SKU0002","Product2");
            list.put("SKU0003","Product3");
            list.put("SKU0004","Product4");
            list.put("SKU0005","Product5");
            list.put("SKU0006","Product6");
            list.put("SKU0007","Product7");
            list.put("SKU0008","Product8");
            list.put("SKU0009","Product9");
            list.put("SKU00010","Product10");
            list.put("SKU00011","Product11");
            list.put("SKU00012","Product12");
            list.put("SKU00013","Product13");

        }
        return list;
    }
}
