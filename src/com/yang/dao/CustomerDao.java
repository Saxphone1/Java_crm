package com.yang.dao;

import com.yang.pojo.Customer;
import com.yang.vo.QueryVo;

import java.util.List;

public interface CustomerDao {

    int getCustmerTotal(QueryVo vo);

    List<Customer> getCustomerList(QueryVo vo);


    Customer editCustomerById(Integer id);

    Customer updateInf(Customer customer);

    Void deletInf(Integer id);
}
