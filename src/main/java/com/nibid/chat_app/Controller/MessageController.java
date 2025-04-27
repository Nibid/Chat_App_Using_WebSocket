package com.nibid.chat_app.Controller;

import com.nibid.chat_app.Model.MessageEntity;
import com.nibid.chat_app.Service.IMessageService;
import com.nibid.chat_app.Utils.ApiConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiConstant.MESSAGE)
public class MessageController {

    private IMessageService messageService;
    private SimpMessagingTemplate messagingTemplate;

    public MessageController(IMessageService messageService, SimpMessagingTemplate messagingTemplate) {
        this.messageService = messageService;
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping(ApiConstant.SEND)
    public ResponseEntity<?> sendMessage(Long senderId, Long receiverId, String msg) {
        MessageEntity message = messageService.sendMessage(senderId, receiverId, msg);
        messagingTemplate.convertAndSend(ApiConstant.TOPIC_MESSAGES, this.sendMessages(senderId, receiverId));
        return ResponseEntity.ok(message);
    }

    @MessageMapping(ApiConstant.VIEW_ALL_MESSAGES)
    @SendTo({ApiConstant.TOPIC_MESSAGES})
    public List<MessageEntity> sendMessages(Long senderId, Long receiverId) {
        return messageService.findBySenderAndReceiver(senderId, receiverId);
    }
}
