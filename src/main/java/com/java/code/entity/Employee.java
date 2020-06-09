package com.java.code.entity;

import com.google.common.base.MoreObjects;

/**
 * created by yuxiaodong01 on 2020/06/05.
 */
public class Employee {


    private String name;

    private String department;

    private String id;

    public Employee(String name, String department, String id) {
        this.name = name;
        this.department = department;
        this.id = id;
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

    public void setId(String id) {
        this.id = id;
    }
}
