package uk.ac.ncl.cs.zequnli.cc.model;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Zzz
 * Date: 13-12-7
 * Time: 下午11:46
 * To change this template use File | Settings | File Templates.
 */
public class Customer4Register {
    @NotNull
    private String country;
    @NotNull
    @Email
    private String email;

    private String firstname;
    private String lastname;
    @NotNull
    private String password;

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
