package com.sda.tools;

import com.sda.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchResultPage searchResultPage;
    private WomenPage womenPage;
    private PopUpPage popUpPage;
    private ShoppingBasketPage shoppingBasketPage;
    private InformationPage informationPage;
    private AuthenticationPage authenticationPage;
    private CreateAnAccountPage createAnAccountPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public MainPage getMainPage() {
        if (mainPage == null){
        mainPage = PageFactory.initElements(driver, MainPage.class);
        }
        return mainPage;
    }
    public WomenPage getWomenPage(){
    if (womenPage == null){
        womenPage = PageFactory.initElements(driver, WomenPage.class);
        }
    return womenPage;
    }
    public PopUpPage getPopUpPage(){
    if (popUpPage == null){
        popUpPage = PageFactory.initElements(driver, PopUpPage.class);
    }
    return popUpPage;
    }
    public ShoppingBasketPage getShoppingBasketPage(){
     if (shoppingBasketPage == null) {
         shoppingBasketPage = PageFactory.initElements(driver, ShoppingBasketPage.class);
     }
     return shoppingBasketPage;
     }
    public InformationPage getInformationPage(){
     if (informationPage == null){
    informationPage = PageFactory.initElements(driver,InformationPage.class);

        }
    return informationPage;
    }
    public SearchResultPage getSearchResultPage() {
     if(searchResultPage == null) {
            searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
     }
     return searchResultPage;
     }
    public AuthenticationPage getAuthenticationPage(){
     if (authenticationPage == null){
         authenticationPage = PageFactory.initElements(driver, AuthenticationPage.class);
     }
     return authenticationPage;
     }
     public CreateAnAccountPage getCreateAnAccountPage(){
     if (createAnAccountPage == null){
         createAnAccountPage = PageFactory.initElements(driver, CreateAnAccountPage.class);
     }
     return createAnAccountPage;
     }
}
