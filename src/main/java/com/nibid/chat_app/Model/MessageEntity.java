package com.nibid.chat_app.Model;

import com.nibid.chat_app.Model.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_message")
public class MessageEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity senderId;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserEntity receiverId;

    @Column(name = "message")
    private String message;
}
