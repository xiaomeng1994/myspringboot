package com.meng.moudle.customer.service.impl;

import com.meng.moudle.customer.mapper.CustomerMapper;
import com.meng.moudle.customer.service.CustomerService;
import com.meng.moudle.customer.vo.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;


    @Override
    public Customer getCustomerById(String customerId) {
        return customerMapper.getCustomerById(customerId);
    }

    @Override
    public List<Customer> getCustomerList() {
        return customerMapper.getCustomerList();
    }

    @Override
    public void deleteCustomerById(String customerId) {
        customerMapper.deleteCustomerById(customerId);
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerMapper.insertCustomer(customer);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        customerMapper.updateCustomerById(customer);
    }

}
