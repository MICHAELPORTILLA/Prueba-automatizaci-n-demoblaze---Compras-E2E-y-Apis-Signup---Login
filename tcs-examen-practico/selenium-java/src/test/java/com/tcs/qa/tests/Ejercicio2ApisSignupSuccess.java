package com.tcs.qa.tests;
import com.intuit.karate.junit5.Karate;

import org.testng.annotations.Test;

public class Ejercicio2ApisSignupSuccess {
    @Karate.Test
    Karate SignupSuccess() {
        return Karate.run("classpath:features").tags("@signup-success");
    }
}
