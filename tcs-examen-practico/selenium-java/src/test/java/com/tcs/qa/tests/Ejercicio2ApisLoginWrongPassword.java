package com.tcs.qa.tests;

import com.intuit.karate.junit5.Karate;
import org.testng.annotations.Test;

public class Ejercicio2ApisLoginWrongPassword {
    @Karate.Test
    Karate LoginWrongPassword() {
        return Karate.run("classpath:features").tags("@login-Wrong-password");
    }
}
