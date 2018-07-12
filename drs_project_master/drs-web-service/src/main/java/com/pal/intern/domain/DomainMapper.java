

package com.pal.intern.domain;

public class DomainMapper {
    private Integer id;
    private String name;

    public DomainMapper(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    
    public DomainMapper() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DomainMapper{" + "id=" + id + ", name=" + name + '}';
    }


   
    

}
