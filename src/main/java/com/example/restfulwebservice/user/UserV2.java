package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("UserInfoV2") //controller, service 에서 사용될 예정
public class UserV2 extends User {

    /**
     * 상속을 위해서는 디폴트 생성자가 필요함. -> User 에 NoArgsConstructor 추가
     */
    private String grade;
}