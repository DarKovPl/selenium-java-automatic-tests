package com.sda.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationPage {

    @FindBy (xpath = "/html/body/div/div[2]/div/div[1]/a")
    private WebElement returnHomePageButton;

    public boolean isVisibleReturnHomePageButton(){
        return returnHomePageButton.isDisplayed();
    }
    public void clickReturnHomePageButton(){
        returnHomePageButton.click();
    }

}
