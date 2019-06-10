package com.sda.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpPage {

    @FindBy ( xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")
    private WebElement proccedToCheckoutButton;
    @FindBy (id = "cart_title")
    private WebElement shoppingCartSummary;

    public WebElement procedToCheckoutButtonWebElement(){
        return proccedToCheckoutButton;
    }

    public boolean isVisibleProccedToCheckoutButton(){
        return proccedToCheckoutButton.isDisplayed();
    }
    public WebElement shoppingCartSummaryWebElement(){
        return shoppingCartSummary;
    }
    public boolean isVisibleShoppingCartSummary(){
        return shoppingCartSummary.isDisplayed();
    }


}
