package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {

    /**
     * Memory DB 사용 예정
     */

    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;

    //초기값 생성
    static {
        users.add(new User(1, "jung hyun", new Date()));
        users.add(new User(2, "park", new Date()));
        users.add(new User(3, "kim", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }
}
