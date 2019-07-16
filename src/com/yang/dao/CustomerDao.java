package com.yang.dao;

import com.yang.pojo.Customer;
import com.yang.vo.QueryVo;

import java.util.List;

public interface CustomerDao {

    int getCustmerTotal(QueryVo vo);

    List<Customer> getCustomerList(QueryVo vo);


}
