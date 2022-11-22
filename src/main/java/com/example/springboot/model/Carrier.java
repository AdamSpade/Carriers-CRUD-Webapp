package com.example.springboot.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Entity
@Table(name="carriers")
public class Carrier {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="carrier_name")
    private String carrierName;

    @Column(name="email")
    private String email;
}
