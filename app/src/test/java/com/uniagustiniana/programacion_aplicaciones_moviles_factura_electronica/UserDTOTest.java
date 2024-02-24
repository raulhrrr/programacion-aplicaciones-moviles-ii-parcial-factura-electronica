package com.uniagustiniana.programacion_aplicaciones_moviles_factura_electronica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class UserDTOTest {

    @Test
    public void getName() {
        UserDTO user = new UserDTO();
        assertNull(user.getName());
    }

    @Test
    public void setName() {
        UserDTO user = new UserDTO();
        user.setName("Miguel");
        assertEquals("Miguel", user.getName());
    }

    @Test
    public void getLastname() {
        UserDTO user = new UserDTO();
        assertNull(user.getLastname());
    }

    @Test
    public void setLastname() {
        UserDTO user = new UserDTO();
        user.setLastname("Rodriguez");
        assertEquals("Rodriguez", user.getLastname());
    }

    @Test
    public void getFullName() {
        UserDTO user = new UserDTO();
        user.setName("Miguel");
        user.setLastname("Rodriguez");
        assertEquals("Miguel Rodriguez", user.getFullName());
    }
}