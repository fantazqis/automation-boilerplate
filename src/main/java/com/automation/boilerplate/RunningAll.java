package com.automation.boilerplate;

import io.cucumber.core.cli.Main;

public class RunningAll {
    public static void main(String[] args) {
        try {
//            System.out.println("Path User Dir -> "+System.getProperty("user.dir"));
            Main.main(new String[]
                    {
                            "-g","com.automation.boilerplate.impl",
                            "classpath:features",
                            "-p","pretty",
                            "-p","html:data-report/PTA/htmlreport/Automation_Report.html",
                            "-p","json:data-report/PTA/jsonreport/Automation_Report.json",
                            "-p","junit:data-report/PTA/junitreport/Automation_Report.xml",
                            "-m"
                    });
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Main Class Execption : "+e);
        }

    }
}