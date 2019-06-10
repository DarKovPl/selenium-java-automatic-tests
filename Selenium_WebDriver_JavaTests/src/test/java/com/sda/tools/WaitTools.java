package com.sda.tools;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTools {
    public static boolean isElementVisible(WebDriver driver, WebElement element) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                return true;
            } catch (TimeoutException e) {
                return false;
            }
    }

    public static boolean isElementOnPage (WebDriver driver, WebElement element, String attribute, String valueOfAttribute ) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.attributeContains(element, attribute, valueOfAttribute));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public static boolean isElementSelected (WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 4);
        try {
            wait.until(ExpectedConditions.elementSelectionStateToBe(element,true));
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }
}
