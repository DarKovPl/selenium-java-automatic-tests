package com.sda.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage {

    @FindBy (id = "email_create")
    private WebElement emailAddressBox;
    @FindBy (id = "SubmitCreate")
    private WebElement submitButton;

    public void inputUserEmailAddress(){
        emailAddressBox.sendKeys("fakemail@helloworld.com");
    }
    public void clickSubmitButton(){
        submitButton.click();
    }

}
