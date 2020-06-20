package com.imust.blog.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Author: wangJianBo
 * Date: 2020/6/16 14:31
 * Content:
 */

@Entity
@Table(name = "blog")
@Data
@ToString
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    @Lob
    @Basic(fetch= FetchType.LAZY)
    private String content;

    /**
     * 描述
     */
    private String represent;


    /**
     * 查看次数
     */
    private long views;

    /**
     * 博客分类
     */
    private String typeId;

    /**
     * 首图
     */
    private String headPicture;

    /**
     * 标记
     */
    private String sign;

    /**
     * 浏览次数
     */
    private Long numberOfViews;

    /**
     * 赞赏开启
     */
    private Boolean appreciate;

    /**
     * 评论
     */
    private String comment;

    /**
     * 推荐
     */

    private Boolean recommend;

    /**
     * 发布
     */
    private Boolean releaseBlog;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate updateTime;
}
