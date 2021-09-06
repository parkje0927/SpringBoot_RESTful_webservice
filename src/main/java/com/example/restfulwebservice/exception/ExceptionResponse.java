package com.example.restfulwebservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor //모든 객체를 갖고 있는 생성자
@NoArgsConstructor //기본 생성자
public class ExceptionResponse {

    /**
     * 예외가 발생한 시간
     * 예외가 발생한 메세지
     * 예외가 발생 내용
     */
    private Date timeStamp;
    private String message;
    private String details;
}
