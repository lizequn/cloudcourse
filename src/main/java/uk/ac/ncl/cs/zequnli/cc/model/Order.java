package uk.ac.ncl.cs.zequnli.cc.model;

import com.microsoft.windowsazure.services.table.client.TableServiceEntity;
import org.apache.commons.lang3.RandomStringUtils;
import uk.ac.ncl.cs.zequnli.cc.util.TableStorage;

import java.util.UUID;

/**
 * @Auther: Li Zequn
 * Date: 08/12/13
 */
public class Order extends TableServiceEntity {
    public Order(){}
    public Order(String email,String id){
        this.partitionKey = email;
        this.rowKey = id;
    }

    private String SKUid;
    private Double price;
    private String country;

    public String getSKUid() {
        return SKUid;
    }

    public void setSKUid(String SKUid) {
        this.SKUid = SKUid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static String generateId(String email){
       // return UUID.fromString(email +System.currentTimeMillis()).toString();
        return RandomStringUtils.randomAlphabetic(6)+(email.hashCode()+System.currentTimeMillis());
    }

}
