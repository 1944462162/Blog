package com.imust.blog.service.impl;

import com.imust.blog.dao.TypeDao;
import com.imust.blog.domain.po.Type;
import com.imust.blog.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/18 16:03
 * Content:
 */
@Service
@Slf4j
public class TyeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;
    @Override
    public Boolean saveType(Type type) {
        try {
            typeDao.save(type);
        } catch (Exception e) {
            log.error(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public List<Type> findAllType() {
        return typeDao.findAll();
    }

    @Override
    public Boolean deleteType(Integer id) {
        try {
            typeDao.deleteById(id);
        } catch (Exception e) {
            log.error(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public Type findOneTypeById(Integer id) {
        return typeDao.getOne(id);
    }
}
