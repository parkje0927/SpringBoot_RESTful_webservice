package com.example.restfulwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * HTTP Status Code
 *
 * 2xx => ok
 * 4xx => Client 문제
 * 5xx => Server 문제
 *
 * 이 예외 클래스는 500번대가 아니라 HttpStatus.NOT_FOUND 에러를 나타나게 한다.
 * -> 404 에러코드
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
    
}
