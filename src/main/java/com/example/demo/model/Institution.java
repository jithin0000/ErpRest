package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String address;
    private String email;
    private String country;
    private String language;
    private String institutioncode;
    private long phone;
    private long mobile;

    public Institution() {
    }

    public Institution(String name, String address, String email, String country, String language, String institutioncode, long phone, long mobile) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.country = country;
        this.language = language;
        this.institutioncode = institutioncode;
        this.phone = phone;
        this.mobile = mobile;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getInstitutioncode() {
        return institutioncode;
    }

    public void setInstitutioncode(String institutioncode) {
        this.institutioncode = institutioncode;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institution that = (Institution) o;
        return id == that.id &&
                phone == that.phone &&
                mobile == that.mobile &&
                name.equals(that.name) &&
                address.equals(that.address) &&
                email.equals(that.email) &&
                country.equals(that.country) &&
                language.equals(that.language) &&
                institutioncode.equals(that.institutioncode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, email, country, language, institutioncode, phone, mobile);
    }
}
