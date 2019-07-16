package com.yang.service;

import com.yang.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {

    List<BaseDict> getBaseDictByTypeCode(String typeCode);

}
