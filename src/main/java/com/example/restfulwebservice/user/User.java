package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password"})
//@JsonFilter("UserInfo") //controller, service 에서 사용될 예정
public class User {

    private Integer id;

    @Size(min = 2, message = "Name 은 2글자 이상 입력해주세요.")
    private String name;

    @Past
    private Date joinDate;

    /**
     * 특정 필드를 노출시키지 않도록 하는 방법
     * 1) @JsonIgnore => 해당 필드는 json 으로 반환이 안 되므로 노출이 안 됨.
     * 2) @JsonIgnoreProperties(value = {"password", "", ..}) => 해당 클래스에서 value 에 해당하는 필드는 노출이 안 됨.
     */
//    @JsonIgnore
    private String password;

//    @JsonIgnore
    private String ssn; //주민등록번호
}