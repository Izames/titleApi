package com.example.titleapi.services;

import com.example.titleapi.models.Role;
import com.example.titleapi.models.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

//@Service
//@RequiredArgsConstructor
//public class UserServiceXXX {
//    private final List<User> users;
//    public UserServiceXXX() {
//        this.users = List.of(
//                new User("admin", "admin", Collections.singleton(Role.ADMIN)),
//                new User("worker", "worker", Collections.singleton(Role.WORKER)),
//                new User("user", "user", Collections.singleton(Role.USER))
//        );
//    }
//    public Optional<User> getByLogin(@NonNull String login){
//        return users.stream().
//                filter(user -> login.equals(user.getLogin()))
//                .findFirst();
//    }
//}
