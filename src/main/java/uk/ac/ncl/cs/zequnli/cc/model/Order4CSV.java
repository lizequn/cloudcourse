package uk.ac.ncl.cs.zequnli.cc.model;

/**
 * @Auther: Li Zequn
 * Date: 11/12/13
 */
public class Order4CSV {
    private String country;
    private String id;
    private String skuid;
    private double price;
    private String email;

    public Order4CSV(Order order) {
        this.country = order.getPartitionKey();
        this.email = order.getEmail();
        this.id = order.getRowKey();
        this.price = order.getPrice();
        this.skuid = order.getSKUid();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSkuid() {
        return skuid;
    }

    public void setSkuid(String skuid) {
        this.skuid = skuid;
    }
}
