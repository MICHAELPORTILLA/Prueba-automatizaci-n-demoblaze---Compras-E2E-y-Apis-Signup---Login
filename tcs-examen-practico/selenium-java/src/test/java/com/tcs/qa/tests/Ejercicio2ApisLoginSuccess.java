package com.tcs.qa.tests;

import com.intuit.karate.junit5.Karate;
import org.testng.annotations.Test;

public class Ejercicio2ApisLoginSuccess {
    @Karate.Test
    Karate LoginSuccess() {
        return Karate.run("classpath:features").tags("@login-success");
    }
}
