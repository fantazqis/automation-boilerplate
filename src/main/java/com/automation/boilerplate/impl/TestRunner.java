package com.automation.boilerplate.impl;


/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author ASUS a.k.a. Muhammad Irfan
Java Developer
Created on 04/11/2024 13:06
@Last Modified 04/11/2024 13:06
Version 1.0
*/

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/main/resources/features/001_Boilerplate.feature",
        },
        glue = "com.automation.boilerplate.impl",
        monochrome = true,
        plugin = {"pretty","html:target/PTA/htmlreport/PrettyReport.html",
                "json:target/PTA/jsonreport/JsonReport.json",
                "junit:target/PTA/junitreport/JunitReport.xml"}
)

public class TestRunner extends AbstractTestNGCucumberTests {}
