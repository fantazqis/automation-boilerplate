package com.automation.boilerplate;
/*
IntelliJ IDEA 2023.3.6 (Community Edition)
Build #IC-233.15026.9, built on March 21, 2024
@Author kiyandark a.k.a. Muhammad Irfan Syaifur Rizal Wiratama
Java Developer
Created on 03/06/2024 21:56
@Last Modified 03/06/2024 21:56
Version 1.0
*/

import io.cucumber.core.cli.Main;

public class RunnerAll {
    public static void main(String[] args) {
//        ConfigSupport.getArgsRunner(args);
        try {
            Main.main(new String[]
                    {
                            "-g","com.automation.boilerplate.impl",
                            "classpath:features",
                            "-p","pretty",
                            "-p","html:target/PTA/htmlreport/LoginRunnerOutline.html",
                            "-p","json:target/PTA/jsonreport/LoginRunnerOutline.json",
                            "-p","junit:target/PTA/junitreport/LoginRunnerOutline.xml",
                            "-m"
                    });
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Main Class Execption : "+e);
        }
    }
}
