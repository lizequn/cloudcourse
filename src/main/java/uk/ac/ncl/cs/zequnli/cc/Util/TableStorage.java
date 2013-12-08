package uk.ac.ncl.cs.zequnli.cc.util;

import com.microsoft.windowsazure.services.core.storage.CloudStorageAccount;
import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.table.client.CloudTableClient;
import com.microsoft.windowsazure.services.table.client.TableOperation;
import uk.ac.ncl.cs.zequnli.cc.model.Product;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * @Auther: Li Zequn
 * Date: 04/12/13
 */
public class TableStorage {

    public static final String constring =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=zequnli;" +
                    "AccountKey=QhAqhRDAj4ZiR9eHZDyxnysnv4chfUKg6pP8o35vFWN4Ki/YRRLtyQzMVMBpynkg8faL/J/9/X3bqEBtED1DfA==";
    public final static String TABLE_CUSTOMER = "Customer";
    public final static String TABLE_PRODUCT = "Product";

    public static CloudStorageAccount getAccount(){
        try {
            CloudStorageAccount storageAccount =
                    CloudStorageAccount.parse(constring);
            return storageAccount;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static CloudTableClient getTableClient(){
        return getAccount().createCloudTableClient();
    }

    private static void createTable(String name){
        // Retrieve storage account from connection-string
         CloudStorageAccount storageAccount = getAccount();

        // Create the table client.
        CloudTableClient tableClient = storageAccount.createCloudTableClient();

        // Create the table if it doesn't exist.
        String tableName = name;
        try {
            tableClient.getTableReference(tableName).createIfNotExist();
        } catch (StorageException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    private static int sku = 0;
    private static String getSKUid(){
        sku++;
        if(sku / 10 ==0 ){
           return "SKU000"+sku;
        }else if(sku/100 == 0) {
           return "SKU00"+sku;
        }else if(sku/1000 ==0){
           return "SKU0" +sku;
        }else {
            return "SKU"+sku;
        }
    }
    private static void addProduct(String category,int num,double minprice,double maxprice){
        String productname =  "Product";
        DecimalFormat df = new DecimalFormat("#.00");
        int i = 0;
        Random r = new Random();
        for(i = 0;i<num;i++){
            Product product = new Product(category,getSKUid());
            product.setProductName(productname+sku);
            double fd = Double.valueOf(df.format((r.nextDouble()*1000)%maxprice + minprice).toString());
            product.setPrice(fd);
            TableOperation operation =  TableOperation.insert(product);
            CloudTableClient tableClient = TableStorage.getTableClient();
            try {
                tableClient.execute(TableStorage.TABLE_PRODUCT,operation);
            } catch (StorageException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

//    public static void main(String [] args){
////        TableStorage.createTable(TABLE_CUSTOMER);
////        TableStorage.createTable(TABLE_PRODUCT);
////        addProduct("Books",20,10.0,100.0);
////        addProduct("Electronics",10,40.0,200.0);
////        addProduct("Sports",10,20.0,200.0);
//
//    }





}
