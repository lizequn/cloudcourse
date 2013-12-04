package uk.ac.ncl.cs.zequnli.cc.model;

import com.microsoft.windowsazure.services.table.client.TableServiceEntity;

/**
 * @Auther: Li Zequn
 * Date: 04/12/13
 */
public class Customer extends TableServiceEntity {
//    private String country;
//    private String email;

    public Customer(){}
    public Customer(String country,String email){
        this.partitionKey = country;
        this.rowKey = email;
    }

    private String firstname;
    private String lastname;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
