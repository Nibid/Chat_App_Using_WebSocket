package com.nibid.chat_app.Repository;

import com.nibid.chat_app.Model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends JpaRepository<MessageEntity, Long>, CrudRepository<MessageEntity, Long> {
}
