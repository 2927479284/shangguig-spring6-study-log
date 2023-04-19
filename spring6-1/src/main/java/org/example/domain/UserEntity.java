package org.example.domain;

import lombok.Data;


/**
 * 用户实体
 */
@Data
public class UserEntity {
    private String id;

    private String userName;

    private String passWord;

    private String userMessage;

}
