package com.nibid.chat_app.Service;

import com.nibid.chat_app.Model.UserEntity;

public interface IUserService {

    UserEntity findByEmail(String email);

    void save(UserEntity userEntity);
}
