package com.imust.blog.controller.Admin;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.domain.po.Search;
import com.imust.blog.domain.po.Tag;
import com.imust.blog.domain.po.Type;
import com.imust.blog.service.BlogService;
import com.imust.blog.service.TagsService;
import com.imust.blog.service.TypeService;
import com.imust.blog.utils.Time;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 10:01
 * Content:
 */

@Controller
@RequestMapping("/admin")
public class BlogInputApiController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagsService tagsService;

    private Integer SearchNumber = 0;

    private Integer PageNumber = 0;

    /**
     * 编写论文进行论文的提交
     * @param blog
     * @param attributes
     * @param modelMap
     * @return
     */
    @PostMapping("/blogs/input/api")
    public String gotoBlogInput(Blog blog, RedirectAttributes attributes, ModelMap modelMap) {
        System.out.println(blog.toString());


        Boolean operationBlog = blogService.saveBlog(blog);
        //当增加博客的时候对应的分类标签数量加一
        Type oneTypeByName = typeService.findOneTypeByName(blog.getTypeId());

        oneTypeByName.setBlogNumber(oneTypeByName.getBlogNumber() + 1);
        typeService.saveType(oneTypeByName);

        //当增加博客的时候对应的标签数量加一
        Tag tagByName = tagsService.findTagByName(blog.getSign());
        tagByName.setTagNumber(tagByName.getTagNumber() + 1);
        tagsService.saveTag(tagByName);

        List<Blog> blogList = blogService.getBlogByPage(1,false);
        List<Type> allType = typeService.findAllType();

        modelMap.put("blogs", blogList);
        modelMap.put("pages", 1);
        modelMap.put("types", allType);
        if (operationBlog){
            attributes.addAttribute("message", "操作成功");
        } else {
            attributes.addAttribute("message", "操作失败");
        }
        return "admin/blogs";
    }

    @GetMapping("/blogs/delete/api")
    public String deleteBlog(@RequestParam("id") Long id, RedirectAttributes attributes,ModelMap modelMap){
        System.out.println("进入delete" + id);
        Blog oneBlogById = blogService.findOneBlogById(id);
        //当删除的时候将分类中对应的数量减一
        Type oneTypeByName = typeService.findOneTypeByName(oneBlogById.getTypeId());

        oneTypeByName.setBlogNumber(oneTypeByName.getBlogNumber() - 1);
        typeService.saveType(oneTypeByName);

        //当增加博客的时候对应的标签数量减一
        Tag tagByName = tagsService.findTagByName(oneBlogById.getSign());
        tagByName.setTagNumber(tagByName.getTagNumber() - 1);
        tagsService.saveTag(tagByName);

        Boolean deleteBlog = blogService.deleteBlog(id);
        modelMap.put("pages", 1);
        if (deleteBlog){
            attributes.addAttribute("message", "操作成功");
        } else {
            attributes.addAttribute("message", "操作失败");
        }
        return "redirect:/admin/blogs";
    }
    @GetMapping("/blogs/update/api")
    public String updateBlog(@RequestParam("id") Long id, Model model){
        Blog blog = blogService.findOneBlogById(id);
        List<Type> allType = typeService.findAllType();
        List<Tag> allTag = tagsService.findAllTag();
        model.addAttribute("tags", allTag);
        model.addAttribute("Blog", blog);
        model.addAttribute("types", allType);
        model.addAttribute("pages", 1);
        return "admin/blogs-input";
    }

    /**
     * 分页查找以及按照关键字查找
     * 关键字查找页号为 0，分页查找传递指定的页号
     * @param search
     * @param modelMap
     * @param attributes
     * @return
     */
    @PostMapping("/blogs/search")
    public String adminSearchBlog(Search search,ModelMap modelMap,RedirectAttributes attributes){
        System.out.println(search.toString());
        System.out.println("page:" + search.getPageOrSearch());
        boolean operationBlog = true;
        List<Blog> blogList;
        //如果是true，说明是点击搜索进行查找，false说明按照上一页下一页进行查找
        if (search.getPageOrSearch()){
            blogList = blogService.searchAdminAllBlogAndByPage(search,search.getPage());
            SearchNumber++;
            PageNumber = 0;
            if (blogList.isEmpty()){
                operationBlog = false;
            }
            if (SearchNumber == 1)
                modelMap.put("pages", 1);
            else
                modelMap.put("pages", search.getPage());
        }
        else{
            blogList = blogService.getBlogByPage(search.getPage(),false);
            SearchNumber = 1;
            PageNumber++;
            if (PageNumber == 0)
                modelMap.put("pages",1);
            else
                modelMap.put("pages", search.getPage());
        }
        System.out.println(blogList.toString());
        List<Type> allType = typeService.findAllType();
        modelMap.put("types", allType);
        modelMap.put("blogs", blogList);
        if (operationBlog){
            attributes.addAttribute("message", "操作成功");
        } else {
            attributes.addAttribute("message", "操作失败");
        }
        return "/admin/blogs :: blogList";
    }

}
