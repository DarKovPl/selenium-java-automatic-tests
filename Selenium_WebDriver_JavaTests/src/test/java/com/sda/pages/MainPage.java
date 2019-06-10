package com.sda.pages;

import jdk.nashorn.internal.parser.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static java.sql.DriverManager.getDriver;

public class MainPage {

    @FindBy (className = "item-img")
    private WebElement saleLink;
    @FindBy (xpath = "/html/body/div/div[2]/div/div[1]/div/div[1]/div/div[1]/ul/li[3]/div/p[2]/button")
    private WebElement threeMovePictureSaleLink;
    @FindBy(xpath = "/html/body/div/div[1]/header/div[1]/div/div/a/img")
    private WebElement saleUpPageLink;
    @FindBy (className = "menu-logo")
    private WebElement pageAfterSaleLink;
    @FindBy (id = "search_query_top")
    private WebElement searchingMainPageBox;
    @FindBy (name = "submit_search")
    private WebElement searchButton;
    @FindBy (xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")
    private WebElement womanListAplification;
    @FindBy (css = ".sf-menu > li:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")
    private WebElement visibleWomanAplificationList;
    @FindBy (xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[1]/a/img")
    private WebElement mainPageElement;
    @FindBy (id = "newsletter-input")
    private WebElement newsletterWindow;
    @FindBy (name = "submitNewsletter")
    private WebElement newsletterButton;
    @FindBy(xpath = "/html/body/div/div[2]/div/p")
    private WebElement alertAfterSuccessAddUserToNewsletter;
    @FindBy (className = "header_user_info")
    private WebElement signInLink;

    ///---------Sale_Link-----------\\\
    public void clickSaleLink(){
        saleLink.click();
    }
    public void clickUpSaleLink(){
        saleUpPageLink.click();
    }
    public void clickThreeMovePictureLink(){
        threeMovePictureSaleLink.click();
    }
    public boolean isVisiblePageAfterSaleLink(){
        return pageAfterSaleLink.isDisplayed();
    }
    ///--------------Search--------------------\\\

    public void searchingFor(String inputWord){
        searchingMainPageBox.sendKeys(inputWord);
    }
    public void tapSearchButton(){
        searchButton.submit();
    }
    ///---------------WomenLink--------------------\\\
    public WebElement aplificationWomenList (){
      return womanListAplification;
    }
    public boolean isVisibleAplificationWomenList(){
        return visibleWomanAplificationList.isDisplayed();
    }

    public boolean isVisibeMainPageElement(){
        return mainPageElement.isDisplayed();
    }
    ///---------------Newsletter--------------------\\\
    public void newsletterInputAddressEmail(){
        newsletterWindow.sendKeys("fakemail@helloworld.com");
    }
    public void clickSubmitNewsletter(){
        newsletterButton.click();
    }
    public String checkAlertMessage(){
        System.out.println(alertAfterSuccessAddUserToNewsletter.getText());
        return alertAfterSuccessAddUserToNewsletter.getText();
    }
    public WebElement checkAlertMessageWebElement(){
       return alertAfterSuccessAddUserToNewsletter;
    }
    ///-----------------SignInToTheShop-------------------\\\
    public void clickSignInLink(){
        signInLink.click();
    }

}
