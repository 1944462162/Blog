package com.imust.blog.domain.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 10:19
 * Content:
 */

@Entity
@Table(name = "types")
@Data
@ToString
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    /**
     * 博客分类
     */
    private String typeName;

    /**
     * 当前分类下有多少篇博客
     */
    private long blogNumber;
}
