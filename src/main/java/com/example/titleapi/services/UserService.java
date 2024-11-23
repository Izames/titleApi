package com.example.titleapi.services;

import com.example.titleapi.models.UserModel;
import lombok.NonNull;

import java.util.Optional;

public interface UserService {
    Optional<UserModel> getByLogin(@NonNull String login);
}
