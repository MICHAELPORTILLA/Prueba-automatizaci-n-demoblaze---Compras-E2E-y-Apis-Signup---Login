package com.tcs.qa.tests;

import com.intuit.karate.junit5.Karate;
import org.testng.annotations.Test;

public class Ejercicio2ApisLoginNotExist {
    @Karate.Test
    Karate LoginNotExist() {
        return Karate.run("classpath:features").tags("@login-user-not-exist");
    }
}
