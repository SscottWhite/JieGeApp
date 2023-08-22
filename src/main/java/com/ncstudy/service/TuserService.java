package com.ncstudy.service;

import com.ncstudy.pojo.Tuser;

import java.util.List;

public interface TuserService {
    void saveTuser(Tuser tuser);

    void saveList(List<Tuser> list);
}
