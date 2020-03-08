package com.sda.Pages;

import com.sda.Tests.MainToolTest;
import com.sda.Tools.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage {

    @FindBy (id = "email_create")
    private WebElement emailAddressBox;
    @FindBy (id = "SubmitCreate")
    private WebElement submitButton;

    public WebElement inputUserEmailAddressWebElement(){
        return  emailAddressBox;
    }
    public String getUserEmailAddressText(){
        return emailAddressBox.getText();
    }
    public void clickSubmitButton(){
        submitButton.click();
    }

}
