package com.automation.boilerplate.impl;


/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author ASUS a.k.a. Muhammad Irfan
Java Developer
Created on 04/11/2024 12:51
@Last Modified 04/11/2024 12:51
Version 1.0
*/

import com.automation.boilerplate.impl.TestHooks;
import com.automation.boilerplate.connection.Constants;
import com.automation.boilerplate.page.*;
import com.automation.boilerplate.util.GlobalFunction;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class ImplementationBoilerplate {
    public WebDriver driver;
    private static ExtentTest extentTest;
    private PageBoilerplate pageBoilerplate;


    public ImplementationBoilerplate(){
        this.driver = TestHooks.driver;
        pageBoilerplate = new PageBoilerplate(driver);
        extentTest = TestHooks.extentTest;

    }

    @When("Test001 Membuka Halaman Web")
    public void test001_membuka_halaman_web() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        driver.get(Constants.WEB_URL);
        System.out.println("1");
        extentTest.log(LogStatus.PASS, "Test001 Membuka Halaman Web");
    }

    @And("Test001 Validasi Halaman Utama")
    public void test001_validasi_halaman_utama() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        String validation = pageBoilerplate.getValidationLoginPage();
        Assert.assertEquals("Accepted usernames are:", validation);

        System.out.println("2");
        extentTest.log(LogStatus.PASS, "Test001 Validasi Halaman Utama");
    }

    @And("^Test001 Input Username (.*)$")
    public void test001_input_username_username(String username) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        pageBoilerplate.clearLoginForm();
        pageBoilerplate.inputUsername(username);
        System.out.println("3");
        extentTest.log(LogStatus.PASS, "Test001 Input Username username");
    }

    @And("^Test001 Input Password (.*)$")
    public void test001_input_password_password(String password) {
    GlobalFunction.delay(Constants.TIMEOUT_DELAY);
    pageBoilerplate.inputPassword(password);
    System.out.println("4");
    extentTest.log(LogStatus.PASS, "Test001 Input Password password");
}

    @And("Test001 Klik Tombol Login")
    public void test001_klik_tombol_login() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        pageBoilerplate.clickButtonLogin();
        System.out.println("5");
        extentTest.log(LogStatus.PASS, "Test001 Klik Tombol Login");
    }

    @Then("Test001 Validasi Halaman Login")
    public void test001_validasi_halaman_login() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        String validation = pageBoilerplate.getAlertLoginWrongCredential();
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", validation);
        boolean status = false;
        status = pageBoilerplate.getLogoAlertLoginWrongCredential();
        Assert.assertTrue(status);
        System.out.println("6");
        extentTest.log(LogStatus.PASS, "Test001 Validasi Halaman Login");
    }

}
