package com.tcs.qa.tests;

import com.tcs.qa.base.BaseTest;

import com.tcs.qa.data.TestData;
import com.tcs.qa.pages.StorePage;


import org.testng.annotations.Test;

public class Ejercicio1E2ETest extends BaseTest {
    String rutaCarpeta = "./evidenciaTest";
    String nomTest;

    @Test (dataProvider = "datosPalceHolder", dataProviderClass = TestData.class)
    public void Ejercicio1CompraE2E (String name, String country, String city, String card, String month, String year){
        StorePage storePage = new StorePage();
        storePage.E2E(name,country,city,card,month,year);
    }
}

