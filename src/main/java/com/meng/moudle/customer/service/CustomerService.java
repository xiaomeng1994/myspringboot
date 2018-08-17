package com.meng.moudle.customer.service;

import com.meng.moudle.customer.vo.Customer;
import com.meng.moudle.user.vo.User;

import java.util.List;

public interface CustomerService {
    //查询顾客集合
    List<Customer> getCustomerList();
    //根据id查询顾客
    Customer getCustomerById(String customerId);
    //根据id删除顾客
    void deleteCustomerById(String customerId);
    //新增顾客
    void insertCustomer(Customer customer);
    //根据id修改顾客
    void updateCustomerById(Customer customer);
}
