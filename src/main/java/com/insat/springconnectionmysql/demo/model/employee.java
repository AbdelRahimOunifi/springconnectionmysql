package com.insat.springconnectionmysql.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private String lastName;

    public employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public employee() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "employee{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof employee)) return false;

        employee employee = (employee) o;

        if (getId() != null ? !getId().equals(employee.getId()) : employee.getId() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
            return false;
        return getLastName() != null ? getLastName().equals(employee.getLastName()) : employee.getLastName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }
}
