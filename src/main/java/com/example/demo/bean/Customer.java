package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.sql.In;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private Integer id;
    private String name;
    private String email;
}
