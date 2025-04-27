package com.nibid.chat_app.Service;

import com.nibid.chat_app.Model.MessageEntity;

import java.util.List;

public interface IMessageService {
    MessageEntity sendMessage(Long senderId, Long receiverId, String msg);

    List<MessageEntity> findBySenderAndReceiver(Long senderId, Long receiverId);
}
