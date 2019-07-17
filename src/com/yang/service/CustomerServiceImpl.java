package com.yang.service;

import com.yang.dao.CustomerDao;
import com.yang.pojo.Customer;
import com.yang.utils.Page;
import com.yang.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

@Autowired
private CustomerDao customerDao;

    @Override
    public Page<Customer> getPageByQueryVo(QueryVo vo) {
        Page<Customer> page = new Page<>();
        if (null != vo) {
            vo.setMaxCount(10);
        if (null != vo.getPage() && !vo.getPage().equals("")) {
            page.setPage(Integer.valueOf(vo.getPage()));
            vo.setStartIndex((Integer.valueOf(vo.getPage()) - 1) * vo.getMaxCount());
        }
        page.setSize(5);
        page.setTotal(customerDao.getCustmerTotal(vo));
        page.setRows(customerDao.getCustomerList(vo));
    }
        return page;
    }

    @Override
    public Customer editCustomerById(Integer id) {
        return customerDao.editCustomerById(id);
    }

    @Override
    public Customer updateInf(Customer customer) {
        return customerDao.updateInf(customer);
    }

    @Override
    public Void deleteInf(Integer id) {
        return customerDao.deletInf(id);
    }


}
