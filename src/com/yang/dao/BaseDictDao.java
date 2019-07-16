package com.yang.dao;

import com.yang.pojo.BaseDict;

import java.util.List;

public interface BaseDictDao {
    List<BaseDict> getBaseDictByTypeCode(String typeCode);
}
