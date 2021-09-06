package com.example.restfulwebservice.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        /**
         * trace 에 에러가 난 코드 부분이 다 노출되면 보안상 위험하므로 해당 부분을 수정해야한다.
         */
        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);

        /**
         * status 201
         *
         * 서버로부터 요청 결과값에 적절한 상태 코드를 반환하는 것이 좋은 REST API 를 설계하는 방법이다.
         * id 를 서버측에서 생성하므로 클라이언트측에서 알수가 없다.
         * 클라이언트가 id 를 알기 위해서는 서버에게 물어봐야하는데, 결과값에 생성한 id 를 전달해주면 네트워크 트래픽을 낮추고 효율적이다!
         * 모든 요청을 구분하지 않고 post 메서드와 응답 코드 200번으로 설계하지 말고 예외 handling 을 사용 권장
         * 적절한 상태 코드 제어가 필요
         */
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()) //위 path 의 가변 변수에 이 id 를 넣음
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }

    //update 만들어보기
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        User updatedUser = service.update(id, user);
        if (updatedUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
