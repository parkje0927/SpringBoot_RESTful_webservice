package com.example.restfulwebservice.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    /**
     * /admin/v1/users/1 과 같이 버전을 추가할 예정
     */

    private UserDaoService service;

    public AdminUserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {
        //MappingJacksonValue cannot be cast to java.util.List

        List<User> users = service.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate", "password");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filters);

        return mapping;
    }

    /**
     * 1) URI 를 통한 Version Control
     * - @GetMapping("/v1/users/{id}")
     *
     * 2) Request Parameter 를 이용한 Version Control
     * - @GetMapping(value = "/users/{id}", params = "version=1")
     *
     * 3) Header 를 이용한 Version Control
     * - 임의로 만들어주면 된다.
     * - @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=1")
     */
    @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=1")
    public MappingJacksonValue retrieveUserV1(@PathVariable int id) {
        User user = service.findOne(id);

        /**
         * trace 에 에러가 난 코드 부분이 다 노출되면 보안상 위험하므로 해당 부분을 수정해야한다.
         */
        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        /**
         * 프로그래밍으로 제어하는 Filtering 방법 - 개별 사용자 조회
         * fillOutAllExcept 에 적혀있는 field 만 조회된다.
         */
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "password", "ssn");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }
    

    /**
     * 1) URI 를 통한 Version Control
     * - @GetMapping("/v2/users/{id}")
     *
     * 2) Request Parameter 를 이용한 Version Control
     * - @GetMapping(value = "/users/{id}", params = "version=2")
     * - ex) http://localhost:8088/admin/users/2/?version=2
     *
     * 3) Header 를 이용한 Version Control
     * - 임의로 만들어주면 된다.
     * - @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=2")
     */
    @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=2")
    public MappingJacksonValue retrieveUserV2(@PathVariable int id) {
        User user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        //UserV2 로 변환
        UserV2 userV2 = new UserV2();
        BeanUtils.copyProperties(user, userV2);
        userV2.setGrade("VIP");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate", "grade");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(userV2);
        mapping.setFilters(filters);

        return mapping;
    }
}
