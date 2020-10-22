package com.java.code.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.java.code.entity.Employee;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by yuxiaodong01 on 2020/07/15.
 */
public class JacksonTest {

    public static void main(String[] args) throws JsonProcessingException, JSONException {

        ObjectMapper objectMapper = new ObjectMapper();


        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("jackson");
        employee.setDepartment(null);
        Map<String, String> map = employee.getMap();
        map.put("field1", "sdsd");
        map.put("field2", "dssdsd");
        map.put("field3", "hiohjo");

        String result = objectMapper.writeValueAsString(employee);

        ObjectNode node = objectMapper.valueToTree(employee);

        JsonNode mapNode = node.get("map");

        //JSONPObject jsonObject  =

        JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(employee));

        Object jsonMap = jsonObject.get("map");

        System.out.println("-------------------------------");
        System.out.println(result);


        String employStr = "{\"id\":\"1\",\"name\":\"jackson\",\"company\":\"dev\"}";

        Employee employ = objectMapper.readValue(employStr, Employee.class);
        List<Employee> employees = new ArrayList<>();
        employees.add(employ);

        List<Employee> employeeList = objectMapper.readValue(objectMapper.writeValueAsString(employees), new TypeReference<List<Employee>>() {

        });


        List<Integer> collect = Stream.of(12, 13, 14).collect(Collectors.toList());


        List<Integer> integers = objectMapper.readValue(objectMapper.writeValueAsString(collect), new TypeReference<List<Integer>>() {
        });



        System.out.println(employeeList);


        String bi = "zx03";
        String s = bi.toUpperCase();

        if(s.startsWith("zx")){
            System.out.println("prefix is zx");
        }


    }
}
