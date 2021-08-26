package com.example.restfulwebservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Setter, Getter, toString
@AllArgsConstructor
@NoArgsConstructor //default 생성자 생성
public class HelloWorldBean {

    private String message;
}
