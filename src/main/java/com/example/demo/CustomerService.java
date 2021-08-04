package com.example.demo;

import com.example.demo.bean.Customer;
import com.example.demo.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerMapper customerMapper;
    public Customer getById(Integer id){
        return customerMapper.getCus(id);
    }
}
