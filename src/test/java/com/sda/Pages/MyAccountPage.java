package com.sda.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {
        @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p")
        private WebElement veryficateSignUp;

        public WebElement isVeryficateSignUp(){
            return veryficateSignUp;
        }
}

