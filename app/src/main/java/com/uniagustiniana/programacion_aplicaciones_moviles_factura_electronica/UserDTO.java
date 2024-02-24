package com.uniagustiniana.programacion_aplicaciones_moviles_factura_electronica;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String name;
    private String lastname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
