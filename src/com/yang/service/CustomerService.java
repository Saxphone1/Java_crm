package com.yang.service;

import com.yang.pojo.Customer;
import com.yang.utils.Page;
import com.yang.vo.QueryVo;

public interface CustomerService {
    Page<Customer> getPageByQueryVo(QueryVo vo);
}
