package com.imust.blog.service.impl;

import com.imust.blog.dao.BlogDao;
import com.imust.blog.domain.po.Blog;
import com.imust.blog.domain.po.Search;
import com.imust.blog.domain.po.Type;
import com.imust.blog.service.BlogService;
import com.imust.blog.utils.Time;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 15:18
 * Content:
 */

@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    /**
     * 规定每页的数量为 10
     */
    private final Integer pageSize = 10;
    @Override
    public Boolean saveBlog(Blog blog) {

        if (blog.getContent().length() > 100){
            blog.setRepresent(blog.getContent().substring(0,100));
        }
        else{
            blog.setRepresent(blog.getContent());
        }

        Time time = new Time();
        try {
            blog.setCreateTime(time.getNowDate());
            blog.setUpdateTime(time.getNowDate());
            blogDao.save(blog);
        } catch (Exception e) {
            log.error("保存博客信息失败：" + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Blog> findAllBlog() {
        return blogDao.findAll();
    }

    @Override
    public Boolean deleteBlog(Long id) {
        try {
            blogDao.deleteById(id);
        } catch (Exception e) {
            log.error(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public Blog findOneBlogById(Long id){
        return blogDao.getOne(id);
    }

    @Override
    public Boolean upDateBlog(Blog blog) {
        try {
            blogDao.save(blog);
        } catch (Exception e) {
            log.error(e.toString());
            return false;
        }
        return true;
    }

    /**
     * 根据分类获取相应的博客
     * @param typeName
     * @return
     */
    @Override
    public List<Blog> findAllBlogByTypeName(String typeName) {
        return blogDao.findAllBlogByType(typeName);
    }

    /**
     * 根据标签获取相应的博客
     * @param tagName
     * @return
     */
    @Override
    public List<Blog> findAllBlogByTagName(String tagName) {
        return blogDao.findAllBlogByTag(tagName);
    }

    @Override
    public List<Blog> searchAllBlog(String keyword) {
        return blogDao.searchAllBlogBykeyword(keyword);
    }

    @Override
    public List<Blog> searchAdminAllBlogAndByPage(Search search,Integer page) {
        List<Blog> blogList = blogDao.searchAdminAllBlog(search.getTitle(), search.getTypeId(), search.getRecommend());
        int firstIndex = (page - 1) * pageSize;
        int lastIndex = page * pageSize;
        if (lastIndex > blogList.size()){
            lastIndex = blogList.size();
        }
        return  blogList.subList(firstIndex, lastIndex);
    }

    /**
     * 分页进行查找，
     * @param page
     * @param releaseBlog  判断是否是发布的
     * @return
     */
    @Override
    public List<Blog> getBlogByPage(Integer page,Boolean releaseBlog) {

        List<Blog> allBlog;
        if (!releaseBlog)
            allBlog = blogDao.findAll();
        else
            allBlog = findBlogByReleaseBlog(releaseBlog);
        int firstIndex = (page - 1) * pageSize;
        int lastIndex = page * pageSize;
        if (lastIndex > allBlog.size()){
            lastIndex = allBlog.size();
        }
        return allBlog.subList(firstIndex, lastIndex);
    }

    @Override
    public List<Blog> findBlogByReleaseBlog(Boolean releaseBlog) {
        return blogDao.findAllBlogByReleaseBlog(releaseBlog);
    }

}
