package com.sda.tools;

import com.sda.pages.RandomEmailAddress;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager1 {
    private WebDriver driver1;
    private RandomEmailAddress randomEmailAddress;

    public PageObjectManager1 (WebDriver driver1){
        this.driver1 = driver1;
    }

    public RandomEmailAddress getRandomEmailAddress(){
        if (randomEmailAddress == null)
            randomEmailAddress = PageFactory.initElements(driver1, RandomEmailAddress.class);
        return randomEmailAddress;
    }
}
