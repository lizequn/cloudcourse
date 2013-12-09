package uk.ac.ncl.cs.zequnli.cc.model;


import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer4Login {
    @Email
    @NotNull
    private String email;
    @NotNull
    private String country;
    @NotNull
    @Size(min = 5)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
