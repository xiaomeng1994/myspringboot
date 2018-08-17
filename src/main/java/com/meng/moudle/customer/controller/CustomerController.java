package com.meng.moudle.customer.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meng.commnon.ReturnMessage;
import com.meng.moudle.customer.service.CustomerService;
import com.meng.moudle.customer.vo.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "/api/customer",description = "顾客管理接口",tags = "UserController")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Resource(name = "customerService")
    private CustomerService customerService;

    @ApiOperation(value = "获取顾客列表信息")
    @RequestMapping(method = RequestMethod.POST,value = "getCustomerList")
    public PageInfo<Customer>  getCustomerList(
             @RequestParam(name = "currentPage",defaultValue = "1") int currentPage,
             @RequestParam(name = "pageSize",defaultValue = "10") int pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<Customer> customerList = customerService.getCustomerList();
        return new PageInfo<>(customerList);
    }

    @ApiOperation(value = "查询顾客",notes = "根据顾客ID获取顾客")
    @ApiParam(required = true,name = "customerId",value = "顾客id")
    @RequestMapping(method = RequestMethod.GET,value = "getCustomerById/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId){
        return customerService.getCustomerById(customerId);
    }

    @ApiOperation(value = "修改顾客",notes = "根据顾客ID修改顾客")
    @RequestMapping(method = RequestMethod.PUT,value = "/updateUserById")
    public ReturnMessage updateUserById(@RequestBody Customer customer){//RequestBody注解让springboot将json对象转换成对象
        customerService.updateCustomerById(customer);
        return new ReturnMessage("修改成功!");
    }

    @ApiOperation(value = "删除顾客",notes = "根据顾客ID删除顾客")
    @ApiParam(required = true,name = "customerId",value = "顾客id")
    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteUserById/{customerId}")
    public ReturnMessage deleteUserById(@PathVariable String customerId) {
        customerService.deleteCustomerById(customerId);
        return new ReturnMessage("删除成功!");
    }

}
