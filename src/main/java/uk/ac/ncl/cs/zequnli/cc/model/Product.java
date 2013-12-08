package uk.ac.ncl.cs.zequnli.cc.model;

import com.microsoft.windowsazure.services.table.client.TableServiceEntity;

/**
 * @Auther: Li Zequn
 * Date: 08/12/13
 */
public class Product extends TableServiceEntity {
    public Product(){}
    public Product(String category,String SKUid){
        this.partitionKey = category;
        this.rowKey = SKUid;
    }


    private Double price;
    private String productName;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "category: "+this.partitionKey+"  productName: "+productName+"  price: "+price;
    }
}
