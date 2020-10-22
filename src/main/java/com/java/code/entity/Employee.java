package com.java.code.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.HashMap;
import java.util.Map;

/**
 * created by yuxiaodong01 on 2020/06/05.
 */
//设置null值不显示
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties({"name", "id"})
public class Employee {

    //@JsonIgnore
    private String id;

    private String name;

    @JsonProperty("company")
    private String department;

    private Map<String, String> map = new HashMap<>();

    public Employee() {

    }

    public Employee(String name, String department, String id) {
        this.name = name;
        this.department = department;
        this.id = id;
    }

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).
                add("id", this.getId())
                .add("name", this.getName())
                .add("department", this.getDepartment()).toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void  initMethod(){
        System.out.println("I am  initialized !");
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
