package uk.ac.ncl.cs.zequnli.cc.util;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import uk.ac.ncl.cs.zequnli.cc.dao.ProductDao;
import uk.ac.ncl.cs.zequnli.cc.dao.impl.ProductDaoImpl;
import uk.ac.ncl.cs.zequnli.cc.model.Product;
import uk.ac.ncl.cs.zequnli.cc.service.ProductService;
import uk.ac.ncl.cs.zequnli.cc.service.impl.ProductServiceImpl;

import java.io.*;
import java.util.*;

/**
 * @Auther: Li Zequn
 * Date: 09/12/13
 */

public class Data4Jmeter {

    private static Map<String,String> generateRandomUser(int num){
        String email = null;
        String password = null;
        String country = null;
        String firstname = null;
        String lastname = null;
        Random random = new Random();
        Set<String> set = Country.getAllCountry().keySet();
        String [] countryArray = new String[20];
        set.toArray(countryArray);
        Map<String,String> map = new HashMap<String, String>();
        while (map.size()<num){
            email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
            password = "aaaaa";
            int i = random.nextInt(12);
            country = countryArray[i];
            firstname =RandomStringUtils.randomAlphabetic(6);
            lastname = RandomStringUtils.randomAlphabetic(6);
            String user = email+","+password+","+ country +","+firstname+","+lastname;
            map.put(email,user);
        }
        return map;
    }
    private static void createUserCSV(){
        try {
            PrintWriter  pw = new PrintWriter(new FileWriter("D://users.csv"));
            Map<String,String> map = generateRandomUser(1000);
            for(Map.Entry<String,String> entry: map.entrySet()){
                pw.println(entry.getValue());
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    private static void repeatCSV(){
        try {
            FileReader fileReader = new FileReader("D://users.csv");
            BufferedReader reader = new BufferedReader(fileReader);
            PrintWriter pw = new PrintWriter(new FileWriter("D://users1m.csv"));
            int i = 0;
            String line = reader.readLine();
            while (line != null){
                for(i = 0;i<1000;i++){
                    pw.println(line);
                }
                line = reader.readLine();
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    private static void products(){
        ProductDao pd = new ProductDaoImpl();
        Iterator<Product> iterator = null;
        try {
            iterator = pd.getAllProduct();
        } catch (StorageException e) {
            e.printStackTrace();

        }
        List<Product> list= new ArrayList<Product>();
        while(iterator.hasNext()){
            Product p = iterator.next();
            list.add(p);
        }
        Random random = new Random();
        int max = list.size();
        int i = 0;
        try {
            PrintWriter pw = new  PrintWriter(new FileWriter("D://products.csv"));
            while(i<1000000){
                i++;
                Product p = list.get(random.nextInt(max));
                String s = p.getRowKey();
                pw.println(s);
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        //createUserCSV();
        //repeatCSV();
        //products();
    }
}
