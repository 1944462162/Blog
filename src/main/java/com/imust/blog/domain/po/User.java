package com.imust.blog.domain.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Author: wangJianBo
 * Date: 2020/6/16 14:52
 * Content:
 */

@Entity
@Table(name = "User")
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    private String userName;

    private String passWord;
}
