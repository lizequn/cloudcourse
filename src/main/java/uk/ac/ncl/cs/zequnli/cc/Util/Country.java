package uk.ac.ncl.cs.zequnli.cc.util;

import java.util.*;

/**
 * @Auther: Li Zequn
 * Date: 08/12/13
 */
public class Country {
    private static Map<String,String> list = null;
    public static  Map<String,String> getAllCountry(){
       if(null == list){
           list = new HashMap<String, String>();
           list.put("United Kingdom","United Kingdom");
           list.put("United States","United States");
           list.put("China","China");
           list.put("France","France");
           list.put("Germany","Germany");
           list.put("Brazil","Brazil");
           list.put("Canada","Canada");
           list.put("Egypt","Egypt");
           list.put("Finland","Finland");
           list.put("Greece","Greece");
           list.put("India","India");
           list.put("Korea","Korea");
           list.put("Japan","Japan");

       }
       return list;
    }

}
