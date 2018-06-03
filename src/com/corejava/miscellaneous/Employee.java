package com.corejava.miscellaneous;

import java.util.Objects;

/**
 * Implementing Equals & Hashcode methods in a class, To show there in between contract.
 * @author Ashutosh
 */
public class Employee {
    private int id;
    private String name;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = (this.id == 0 ? 0 : Objects.hashCode(this.id)) + (this.name==null ? 0 : Objects.hashCode(this.name));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Employee emp = (Employee) obj;
        if (this.id == emp.id && Objects.equals(this.id, emp.id) && this.name == emp.name && Objects.equals(this.name, emp.name)) {
            return true;
        }
        return false;
    }
    
}
