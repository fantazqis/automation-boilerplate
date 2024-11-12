package com.automation.boilerplate.page;


/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author ASUS a.k.a. Muhammad Irfan
Java Developer
Created on 04/11/2024 13:04
@Last Modified 04/11/2024 13:04
Version 1.0
*/

import com.automation.boilerplate.connection.Constants;
import com.automation.boilerplate.connection.DriverSingleton;
import com.automation.boilerplate.util.GlobalFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBoilerplate {
    WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement textFieldUsername;

    @FindBy(id = "password")
    private WebElement textFieldPassword;

    @FindBy(css = "#login-button")
    private WebElement buttonLoginButton;

    @FindBy(xpath = "//h4[normalize-space()='Accepted usernames are:']")
    private WebElement textValidationLoginPage;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement alertLoginWrongCredential;

    @FindBy(xpath = "//button[@class='error-button']//*[name()='svg']")
    private WebElement logoAlertLoginWrongCredential;

    public PageBoilerplate(WebDriver driver){
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(this.driver,this);
    }

    public void clearLoginForm()
    {
        try
        {
            /** Set Field Password Empty String */
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(textFieldUsername)).clear();
            /** Set Field Username Empty String */
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(textFieldPassword)).clear();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void inputUsername(String username)
    {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);

        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(textFieldUsername)).sendKeys(username);
        }catch (Exception e){
            System.out.println("Komponen Text Field Input Username Tidak Ditemukan !!");
        }
    }

    public void inputPassword(String password)
    {
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(textFieldPassword)).sendKeys(password);
        }
        catch (Exception e)
        {
            System.out.println("Komponen Text Field Input Password Tidak Ditemukan !!");
        }
    }

    public void clickButtonLogin()
    {
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(buttonLoginButton)).click();
        }
        catch (Exception e)
        {
            System.out.println("Komponen Tombol Login Submit Tidak Ditemukan !!");
        }
    }

    public String getAlertLoginWrongCredential()
    {
        return (this.alertLoginWrongCredential == null) ? "" : new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(alertLoginWrongCredential)).getText();
    }


    public boolean getLogoAlertLoginWrongCredential()
    {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(logoAlertLoginWrongCredential));
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Komponen Alert Login Tidak Ditemukan !!");
            return false;
        }

    }

    public String getValidationLoginPage()
    {
        return (this.textValidationLoginPage == null) ? "" : new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(textValidationLoginPage)).getText();
    }


}
