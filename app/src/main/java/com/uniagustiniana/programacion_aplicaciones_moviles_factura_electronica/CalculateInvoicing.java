package com.uniagustiniana.programacion_aplicaciones_moviles_factura_electronica;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CalculateInvoicing {

    public static final String MESSAGE = "Costo U. $ %s";
    private final Map<String, BigDecimal> products = new HashMap<>();

    public CalculateInvoicing() {
        products.put("tomato", new BigDecimal("1000"));
        products.put("onion", new BigDecimal("2000"));
    }

    public Map<String, BigDecimal> getProducts() {
        return products;
    }

    public BigDecimal calculateTotal(BigDecimal qtTomatoNumber, BigDecimal qtOnionNumber) {
        return qtTomatoNumber.multiply(products.get("tomato"))
                .add(qtOnionNumber.multiply(products.get("onion")));
    }

}
