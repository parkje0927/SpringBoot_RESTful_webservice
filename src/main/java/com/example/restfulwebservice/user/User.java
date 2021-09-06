package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

//@Entity
@Data
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private Date joinDate;
}
