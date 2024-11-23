package com.example.titleapi.controllers;

import com.example.titleapi.DTOModels.RoleModelDTO;
import com.example.titleapi.DTOModels.UserModelDTO;
import com.example.titleapi.DTOModels.UserRoleDTO;
import com.example.titleapi.models.Role;
import com.example.titleapi.models.UserModel;
import com.example.titleapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api-user")
public class UserController {
    @Autowired
    public UserRepository userRepository;
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String createUser(@RequestBody UserModelDTO userDTO){
        UserModel userModel = new UserModel();
        userModel.setLogin(userDTO.getUsername());
        userModel.setPassword(userDTO.getPassword());
        if (userDTO.getRole_id()==0){
            userModel.setRoles(Collections.singleton(Role.ADMIN));
        } else if (userDTO.getRole_id() == 1){
            userModel.setRoles(Collections.singleton(Role.WORKER));
        } else if (userDTO.getRole_id()== 2){
            userModel.setRoles(Collections.singleton(Role.USER));
        }
        userRepository.save(userModel);
        return "success!";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<UserModelDTO> getUsers(){
        List<UserModel> users = userRepository.findAll();
        List<UserModelDTO> userDTOS = new ArrayList<>();
        for (int i = 0; i<users.size(); i++){
            UserModel u = users.get(i);
            long role = 2;
            if (u.getRoles()==Collections.singleton(Role.ADMIN)){
                role=0;
            } else if (u.getRoles()==Collections.singleton(Role.WORKER)){
                role=1;
            } else if (u.getRoles()==Collections.singleton(Role.USER)){
                role=2;
            }
            UserModelDTO user = new UserModelDTO(u.getID(), u.getLogin(), u.getPassword(), role);
            userDTOS.add(user);
        }
        return userDTOS;
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{ID}")
    public String updateUser(@PathVariable long ID, @RequestBody UserModelDTO userDTO){
        UserModel user = userRepository.findById(ID).orElse(null);
        user.setLogin(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        if (userDTO.getRole_id()==0){
            user.setRoles(Collections.singleton(Role.ADMIN));
        } else if (userDTO.getRole_id() == 1){
            user.setRoles(Collections.singleton(Role.WORKER));
        } else if (userDTO.getRole_id()== 2){
            user.setRoles(Collections.singleton(Role.USER));
        }
        userRepository.save(user);
        return "success!";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{ID}")
    public String deleteUser(@PathVariable long ID){
        UserModel user = userRepository.findById(ID).orElse(null);
        userRepository.delete(user);
        return "success!";
    }
}
