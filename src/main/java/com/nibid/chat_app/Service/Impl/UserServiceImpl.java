package com.nibid.chat_app.Service.Impl;

import com.nibid.chat_app.Model.UserEntity;
import com.nibid.chat_app.Repository.IUserRepository;
import com.nibid.chat_app.Service.IUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findAll().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst().orElse(null);
    }

    @Override
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> findAllUser(String email) {
        SecurityContextHolder.getContext().getAuthentication().getDetails();
        return userRepository.findAll().stream()
                .filter(user -> !user.getEmail().equalsIgnoreCase(email))
                .toList();
    }
}
