package com.yang.service;

import com.yang.dao.BaseDictDao;
import com.yang.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService{

    @Autowired
    private BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> getBaseDictByTypeCode(String typeCode) {
        return baseDictDao.getBaseDictByTypeCode(typeCode);
    }
}
