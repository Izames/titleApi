package com.example.titleapi.services;

import com.example.titleapi.models.UserModel;
import com.example.titleapi.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImplService implements UserService{
    private final UserRepository userRepository;
    public ImplService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserModel> getByLogin(@NonNull String login) {
        return Optional.ofNullable(userRepository.findByLogin(login));
    }
}
