package com.imust.blog.domain.po;

import lombok.Data;
import lombok.ToString;

/**
 * Author: wangJianBo
 * Date: 2020/6/22 8:44
 * Content:
 */

@Data
@ToString
public class Search {

    private String title;

    private String typeId;

    private Boolean recommend;

    private Integer page;

    private Boolean pageOrSearch;
}
