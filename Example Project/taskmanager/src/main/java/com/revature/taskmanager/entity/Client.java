package com.revature.taskmanager.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

/*
    NOTE: if I had taken more time to think about it, I could have created one entity
    to represent my users, separating their type via a role property.

    If you are not using Lombok to generate resources at run time you will need to make
    sure you manually add the following:
    - getters/setters for each field
    - no args and full args constructors
    - override the toString, equals, and hashCode methods
 */
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column
    private String email;
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Client() {}

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(getEmail(), client.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getEmail());
    }
}
