package com.ncstudy.service.impl;

import com.ncstudy.mapper.TuserMapper;
import com.ncstudy.pojo.Tuser;
import com.ncstudy.service.TuserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuserServiceImpl implements TuserService {

    @Autowired
    private TuserMapper tuserMapper;
    @Override
    public void saveTuser(Tuser tuser) {
        tuserMapper.saveUser(tuser);
    }

    @Override
    public void saveList(List<Tuser> list) {

        System.out.println(Thread.currentThread().getName()+" "+list.size());
        if(list.size() <= 0) return ;
        tuserMapper.saveList(list);
    }
}
