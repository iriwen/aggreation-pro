package com.java.code.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.code.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * created by yuxiaodong01 on 2020/07/15.
 */
public class JacksonTest {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();


        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("jackson");
        employee.setDepartment(null);

        String result = objectMapper.writeValueAsString(employee);

        System.out.println(result);


        String employStr = "{\"id\":\"1\",\"name\":\"jackson\",\"company\":\"dev\"}";

        Employee employ = objectMapper.readValue(employStr, Employee.class);
        List<Employee> employees = new ArrayList<>();
        employees.add(employ);

        List<Employee> employeeList = objectMapper.readValue(objectMapper.writeValueAsString(employees), new TypeReference<List<Employee>>() {

        });


        System.out.println(employeeList);
    }
}
