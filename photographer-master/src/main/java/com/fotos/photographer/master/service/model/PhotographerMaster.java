package com.fotos.photographer.master.service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "photographer_master")
public class PhotographerMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="status")
    private String status;

    @Column(name="start_year")
    private int startYear;

    @Column(name="address_line_1")
    private String addressLine1;

    @Column(name="address_line_2")
    private String addressLine2;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="pin_code")
    private String pinCode;

    @Column(name="country")
    private String country;

    @Column(name="phone_no_1")
    private String phoneNo1;

    @Column(name="phone_no_2")
    private String phoneNo2;

    @Column(name="website")
    private String website;

    @Column(name="email")
    private String email;

    @Column(name="company_name")
    private String companyName;

    @Column(name="registered")
    private String registered;

    @Column(name="registration_date")
    private Date registrationDate;

    @Column(name="member_since")
    private Date memberSince;

    @Column(name="state_mobility")
    private String stateMobility;

    @Column(name="international_mobility")
    private String internationalMobility;

    @Column(name="video")
    private String video;

    @Column(name="photo")
    private String photo;

}
