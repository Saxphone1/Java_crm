package com.yang.controller;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.yang.pojo.BaseDict;
import com.yang.pojo.Customer;
import com.yang.service.BaseDictService;
import com.yang.service.CustomerService;
import com.yang.utils.Page;
import com.yang.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private BaseDictService baseDicService;

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/customerList.do")
public String getCustomerList(QueryVo vo , Model model , HttpServletRequest request) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");

        if(null != vo && vo.getCustName() != null){
            vo.setCustName(new String(vo.getCustName().getBytes("ISO-8859-1"),"UTF-8"));
            System.out.println(vo.getCustName());
        }

        List<BaseDict> industryType = baseDicService.getBaseDictByTypeCode("001");
        List<BaseDict> fromType = baseDicService.getBaseDictByTypeCode("002");
        List<BaseDict> levelType = baseDicService.getBaseDictByTypeCode("006");

        model.addAttribute("industryType" , industryType);
        model.addAttribute("fromType" , fromType);
        model.addAttribute("levelType" , levelType);


        Page<Customer> page = customerService.getPageByQueryVo(vo);
        model.addAttribute("page",page);
        model.addAttribute("custName",vo.getCustName());
        model.addAttribute("custSource",vo.getCustSource());
        model.addAttribute("custIndustry",vo.getCustIndustry());
        model.addAttribute("custLevel",vo.getCustLevel());
        return "customer";
        }

        @RequestMapping("/editCustomer.do")
        @ResponseBody
        public Customer getCustomerForm(Integer id, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
           Customer customer = customerService.editCustomerById(id);

            return  customer;
        }
        @RequestMapping("/update.do")
        @ResponseBody
    public void updateCustomerForm(Customer customer){
            customerService.updateInf(customer);
        }


        @RequestMapping("/deleteCustomer.do")
        @ResponseBody
        public void deleteCustomer(Integer id){
            customerService.deleteInf(id);
        }
}
