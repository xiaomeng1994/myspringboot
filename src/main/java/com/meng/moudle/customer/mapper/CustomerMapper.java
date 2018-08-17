package com.meng.moudle.customer.mapper;

import com.meng.moudle.customer.vo.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    //查询顾客集合
    List<Customer> getCustomerList();
    //根据id查询顾客
    Customer getCustomerById(String customerId);
    //根据id删除顾客
    void deleteCustomerById(String userId);
    //新增顾客
    void insertCustomer(Customer customer);
    //根据id修改顾客
    void updateCustomerById(Customer customer);
}