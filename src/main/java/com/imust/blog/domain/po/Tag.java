package com.imust.blog.domain.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 10:20
 * Content:
 */

@Entity
@Table(name = "tag")
@Data
@ToString
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    private String tagName;

    private long tagNumber;

}
