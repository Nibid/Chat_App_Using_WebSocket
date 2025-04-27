package com.nibid.chat_app.Service.Impl;

import com.nibid.chat_app.Model.MessageEntity;
import com.nibid.chat_app.Repository.IMessageRepository;
import com.nibid.chat_app.Service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessageRepository messageRepository;

    public MessageServiceImpl(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageEntity sendMessage(Long senderId, Long receiverId, String msg) {
        MessageEntity message = new MessageEntity();
        message.getSender().setId(senderId);
        message.getReceiver().setId(receiverId);
        message.setMessage(msg);
        return messageRepository.save(message);
    }

    @Override
    public List<MessageEntity> findBySenderAndReceiver(Long senderId, Long receiverId) {
        return messageRepository.findAll().stream()
                .filter(msg -> (msg.getSender().getId().equals(senderId) && msg.getReceiver().getId().equals(receiverId)) ||
                        (msg.getSender().getId().equals(receiverId) && msg.getReceiver().getId().equals(senderId)))
                .toList();
    }
}
