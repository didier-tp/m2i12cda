
package com.mycompany.app2;


public class Person {
    
    private String name;
    private Integer size;
    //...

    public Person(String name, Integer size) {
        this.name = name;
        this.size = size;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", size=" + size + '}';
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    
    
    
}
