package uk.ac.ncl.cs.zequnli.cc.model;

import com.microsoft.windowsazure.services.table.client.TableServiceEntity;
import uk.ac.ncl.cs.zequnli.cc.util.TableStorage;

/**
 * @Auther: Li Zequn
 * Date: 08/12/13
 */
public class Order extends TableServiceEntity {
    public Order(){}
    public Order(String email,String SKUid){
        this.partitionKey = email;
        this.rowKey = SKUid;
    }


    private Double price;
    private String country;

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
}
