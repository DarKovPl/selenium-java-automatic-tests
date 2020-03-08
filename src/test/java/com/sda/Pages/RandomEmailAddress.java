package com.sda.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RandomEmailAddress {

    @FindBy (xpath = "//*[@id=\"login\"]")
    private WebElement randomEmailAddress;

    public String getRandomAddressEmail(){
        return randomEmailAddress.getAttribute("value");
    }
    public WebElement randomAddresEmailWebElement(){
        return randomEmailAddress;
    }

}
