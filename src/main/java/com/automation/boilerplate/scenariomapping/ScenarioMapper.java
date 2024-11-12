package com.automation.boilerplate.scenariomapping;


/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author ASUS a.k.a. Muhammad Irfan
Java Developer
Created on 04/11/2024 13:00
@Last Modified 04/11/2024 13:00
Version 1.0
*/


public enum ScenarioMapper {
    T1("Test001 Opening web");

    private String testName;

    private ScenarioMapper(String value) {
        testName = value;
    }

    public String getTestName() {
        return testName;
    }
}
