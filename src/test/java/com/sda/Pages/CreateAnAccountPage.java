package com.sda.Pages;

import com.sda.Tools.WaitTools;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy (id = "customer_firstname")
    private WebElement customerFirstName;
    @FindBy (id = "customer_lastname")
    private WebElement customerLastName;
    @FindBy (id = "email")
    private WebElement veryficateAddressEmail;
    @FindBy (id = "passwd")
    private WebElement userPassword;
    @FindBy (id = "days")
    private WebElement userDayOfBirth;
    @FindBy (id = "months")
    private WebElement userMonthOfBirth;
    @FindBy(id = "years")
    private WebElement userYearOfBirth;
    @FindBy (id = "firstname")
    private WebElement checkUserNameInAddressPanel;
    @FindBy (id = "lastname")
    private WebElement checkUserLastNameInAddressPanel;
    @FindBy (id = "address1")
    private WebElement userAddress;
    @FindBy (id = "city")
    private WebElement userCity;
    @FindBy (id = "id_state")
    private WebElement userState;
    @FindBy (id = "postcode")
    private WebElement userPostalCode;
    @FindBy (id = "id_country")
    private WebElement userCountry;
    @FindBy (id = "phone_mobile")
    private WebElement userPhoneNumber;
    @FindBy (id = "submitAccount")
    private WebElement registerButton;

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
    ///----------------Personal_Data-----------------\\\
    public void addCustomerFirstName(){
        customerFirstName.sendKeys("Władysława");
    }
    public void addCustomerLastName(){
        customerLastName.sendKeys("Żółciak");
    }
    public WebElement addUserDayOfBirthWebElement(){
        return userDayOfBirth;
    }
    public WebElement addUserMonthOfBirthWebElement(){
        return userMonthOfBirth;
    }
    public WebElement addUserYearOfBirthWebElement(){
        return userYearOfBirth;
    }
    public boolean getUserDayOfBirth(){
        return userDayOfBirth.getText().contains("31");
    }
    public boolean getUserMonthOfBirth(){
        return userMonthOfBirth.getText().contains("December");
    }
    public boolean getUserYearOfBirth(){
        return userYearOfBirth.getText().contains("1921");
    }
    ///---------------Address_Panel---------------\\\
    public WebElement checkUserNameInAddressPanelWebElement(){
        return checkUserNameInAddressPanel;
    }
    public WebElement checkUserLastNameInAddressPanelWebElement(){
        return checkUserLastNameInAddressPanel;
    }
    public void addUserAddress(){
        userAddress.sendKeys("Wietrzychowice 19");
    }
    public WebElement userAddressWebElement(){
        return userAddress;
    }
    public void addUserCity (){
        userCity.sendKeys("Wietrzychowice");
    }
    public WebElement userCityWebElement(){
        return userCity;
    }
    public WebElement addUserStateWebElement(){
        return userState;
    }
    public void addUserPostalCode(){
        userPostalCode.sendKeys("80000");
    }
    public WebElement userPostalCodeWebElement(){
        return userPostalCode;
    }
    public WebElement selectUserCountryWebElement(){
        return userCountry;
    }
    public void addUserPhoneNumber(){
        userPhoneNumber.sendKeys("555-55-55");
    }
    public WebElement userPhoneNumberWebElement(){
        return userPhoneNumber;
    }
    ///------------Verificate_Email_Address--------\\\
    public String getUserAddressEmail(){
        return  veryficateAddressEmail.getText();
    }
    ///-------------------Password------------------\\\
    public void addUserPassword(){
        userPassword.sendKeys("Żółć10256");
    }
    ///------------------Click_Add_User--------------\\\
    public void clickRegisterButton(){
        registerButton.click();
    }
}
