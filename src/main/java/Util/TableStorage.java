package Util;

import com.microsoft.windowsazure.services.core.storage.CloudStorageAccount;
import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.table.client.CloudTableClient;
import com.microsoft.windowsazure.services.table.client.TableOperation;
import uk.ac.ncl.cs.zequnli.cc.model.Customer;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

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

//    public static void main(String [] args){
//        TableStorage.createTable(TABLE_CUSTOMER);
//    }





}
