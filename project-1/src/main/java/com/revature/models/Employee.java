package com.revature.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "ers_users",schema = "users")
public class Employee implements Serializable {
    @Id @GeneratedValue()
    @Column(name = "ers_users_id")
    private int id;
    @Column(name = "user_first_name")
    private String firstName;
    @Column(name = "user_last_name")
    private String lastName;
    @Column(name = "ers_username")
    private String username;
    @Column(name = "ers_password")
    private String password;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_role_id")
    private int userRole;

    public Employee(int id, String firstName, String lastName, String username, String password, String email, int userRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }

    public Employee() {}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() &&
                getUserRole() == employee.getUserRole() &&
                getFirstName().equals(employee.getFirstName()) &&
                getLastName().equals(employee.getLastName()) &&
                getUsername().equals(employee.getUsername()) &&
                getPassword().equals(employee.getPassword()) &&
                getEmail().equals(employee.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getUsername(), getPassword(), getEmail(), getUserRole());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRole=" + userRole +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
