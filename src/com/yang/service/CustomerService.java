package com.yang.service;

import com.yang.pojo.Customer;
import com.yang.utils.Page;
import com.yang.vo.QueryVo;

public interface CustomerService {
    Page<Customer> getPageByQueryVo(QueryVo vo);

    Customer editCustomerById(Integer id);


    Customer updateInf(Customer customer);

    Void deleteInf(Integer id);
}
