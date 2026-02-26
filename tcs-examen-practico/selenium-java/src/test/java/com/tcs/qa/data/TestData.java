package com.tcs.qa.data;

import org.testng.annotations.DataProvider;

public class TestData {

    // Data de Place Order
    @DataProvider(name = "datosPalceHolder")
    public static Object[][] datosPalceHolder() {
        return new Object[][] {
                {"Michael Portilla","Colombia","Bogotá",
                        "1234 5678 9012 3456","February","2029"}
        };
    }

    // Data de Place Order
    @DataProvider(name = "productosCompra")
    public static Object[][] datosCompras() {
        return new Object[][] {
                {"Michael Portilla","Colombia","1234 5678 9012 3456","February","2026"}
        };
    }
}
