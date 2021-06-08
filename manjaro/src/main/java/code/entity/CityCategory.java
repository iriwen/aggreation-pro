package code.entity;

import java.util.List;

public class CityCategory {


    private Integer parentId;
    private Integer id ;
    private Integer department;
    private List<CityCategory>  cityList;


    public CityCategory(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public List<CityCategory> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityCategory> cityList) {
        this.cityList = cityList;
    }
}
