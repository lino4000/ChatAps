package com.lino4000.ChatAps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
	
	@Id @GeneratedValue
	private Integer id;
    @Transient
    private MessageType type;
    private String content;
    @ManyToOne
    private User user;
    @Transient
    private String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
