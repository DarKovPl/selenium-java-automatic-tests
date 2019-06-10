package com.sda.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {

    @FindBy (xpath = "/html/body/div/div[2]/div/div[3]/div[2]/h1/span[1]")
    private WebElement resultResultSerchWord;


    public WebElement getResultSearchWorldPublic(){
        return resultResultSerchWord;
    }
    public String getResultSearchWorld(){
        System.out.println(resultResultSerchWord.getText());
        return resultResultSerchWord.getText();
    }





}
