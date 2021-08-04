package com.example.demo.mapper;

import com.example.demo.bean.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    public Customer getCus(Integer id);
}
