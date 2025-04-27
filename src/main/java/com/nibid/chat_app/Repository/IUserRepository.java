package com.nibid.chat_app.Repository;

import com.nibid.chat_app.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long>, CrudRepository<UserEntity, Long> {
}
