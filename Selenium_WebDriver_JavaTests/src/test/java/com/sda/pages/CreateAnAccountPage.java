package com.sda.pages;

import com.sda.tools.WaitTools;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage {

    @FindBy (xpath = "/html/body/div/div[2]/div/div[3]/div/h1")
    private WebElement createAnAccountNamePage;
    @FindBy (id = "uniform-id_gender1")
    private WebElement genderMrRadioButton;
    @FindBy (id = "uniform-id_gender2")
    private WebElement genderMrsRadioButton;
    @FindBy (xpath = "//*[@id=\"id_gender1\"]")
    private WebElement mrRadioButtonAfterClick;
    @FindBy (xpath = "//*[@id=\"id_gender2\"]")
    private WebElement mrsRadioButtonAfterClick;


    public WebElement createAnAccountPageNameWebElement(){
        return createAnAccountNamePage;
    }
    public WebElement genderMrRadioButtonWebElement(){
        return genderMrRadioButton;
    }
    public void clickOnMrsRadioButton(){
        genderMrsRadioButton.click();
    }
    public void clickOnMrRadioButton(){
        genderMrRadioButton.click();
    }
    public WebElement checkMrRadioButton(){
        return mrRadioButtonAfterClick;
    }
    public WebElement checkMrsRadioButton(){
        return mrsRadioButtonAfterClick;
    }
}
