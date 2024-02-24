package com.uniagustiniana.programacion_aplicaciones_moviles_factura_electronica;

import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigDecimal;

public class CalculateInvoicingTest {

    @Test
    public void getProducts() {
        CalculateInvoicing calculateInvoicing = new CalculateInvoicing();
        assertNotNull(calculateInvoicing.getProducts());
    }

    @Test
    public void calculateTotal() {
        CalculateInvoicing calculateInvoicing = new CalculateInvoicing();
        assertEquals("3000", calculateInvoicing.calculateTotal(new BigDecimal("1"), new BigDecimal("1")).toString());
        assertEquals("10000", calculateInvoicing.calculateTotal(new BigDecimal("2"), new BigDecimal("4")).toString());
    }
}