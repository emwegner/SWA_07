package org.acme.boundary.rest.DTOs;
import java.util.Objects;

public class LoginDTO {
    private String name;
    private String password;


    public LoginDTO() {
    }

    public LoginDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDTO name(String name) {
        setName(name);
        return this;
    }

    public LoginDTO password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
    
}
