package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

@NoArgsConstructor
@Table(name="account_details")
public class Account extends BaseEntity{

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @OneToOne(mappedBy = "account")
    private User user;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public UserRole getRole() {
        return role;
    }

    public User getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", postalCode='" + postalCode + '\'' +
                ", role=" + role +
                '}';
    }
}
