package com.tcs.qa.tests;

import com.intuit.karate.junit5.Karate;
import org.testng.annotations.Test;

public class Ejercicio2ApisSingupFail {
    @Karate.Test
    Karate SignupFail() {
        return Karate.run("classpath:features").tags("@signup-fail");
    }
}
