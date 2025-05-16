package com.hcltech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String email;

    private String mobile;

    public Profile( String email, String mobile) {
        this.email = email;
        this.mobile = mobile;
    }

    public Profile(){

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "Id=" + Id +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                '}';
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}
