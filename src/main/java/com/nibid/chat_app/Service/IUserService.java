package com.nibid.chat_app.Service;

import com.nibid.chat_app.Model.UserEntity;

import java.util.List;

public interface IUserService {

    UserEntity findByEmail(String email);

    void save(UserEntity userEntity);

    List<UserEntity> findAllUser(String email);
}
