package com.sda.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingBasketPage {

    @FindBy (xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/div/a[2]/span")
    private WebElement plusButton;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/input[2]")
    private WebElement summaryQtyNumber;

    public void clickPlusButton(){
        plusButton.click();
    }
    public boolean isVisiblePlusButton(){
        return plusButton.isDisplayed();
    }
    public WebElement summaryQtyNumberWebElement(){
        return summaryQtyNumber;
    }


}
