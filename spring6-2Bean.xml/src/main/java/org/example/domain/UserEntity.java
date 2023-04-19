package org.example.domain;

import lombok.Data;


/**
 * 用户实体
 */
@Data
public class UserEntity {

    public UserEntity() {
    }

    public UserEntity(String id, String userName, String passWord, String userMessage) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.userMessage = userMessage;
    }

    private String id;

    private String userName;

    private String passWord;

    private String userMessage;

}
