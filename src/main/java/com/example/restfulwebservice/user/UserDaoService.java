package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
        users.add(new User(1, "jung hyun", new Date(), "pass1", "123456-1234567"));
        users.add(new User(2, "park", new Date(), "pass2", "123456-1234567"));
        users.add(new User(3, "kim", new Date(), "pass3", "123456-1234567"));
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

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }

    public User update(int id, User user) {
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()) {
            User tempUser = iterator.next();
            if (tempUser.getId() == id) {
                tempUser.setName(user.getName());
                return tempUser;
            }
        }

        return null;
    }
}
