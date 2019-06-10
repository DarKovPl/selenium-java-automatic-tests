package com.sda.tests;
import com.sda.tools.PageObjectManager;
import com.sda.tools.WaitTools;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import java.security.PublicKey;

import static org.junit.Assert.*;


public class MainToolTest {
    private WebDriver driver;
    private PageObjectManager manager;

    public MainToolTest(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver  = new FirefoxDriver();
        //driver  = new ChromeDriver();
        manager = new PageObjectManager(driver);


    }


    @Test
    public void mainPageLinkTest(){
        driver.get("http://automationpractice.com");
        manager.getMainPage().clickSaleLink();
        assertTrue(manager.getMainPage().isVisiblePageAfterSaleLink());
        driver.quit();
    }
    @Test
    public void mainPageLinkTest_1(){
        driver.get("http://automationpractice.com");
        manager.getMainPage().clickThreeMovePictureLink();
        assertTrue(manager.getMainPage().isVisiblePageAfterSaleLink());
        driver.quit();
    }
    @Test
    public void mainPageLinkTest_2(){
        driver.get("http://automationpractice.com");
        manager.getMainPage().clickUpSaleLink();
        driver.quit();
    }


    ///-----------------------ZAD 2 ------------------------\\\

    @Test
    public void womenPageFiltersTest(){
        driver.get("http://automationpractice.com");

        manager.getWomenPage().clickWomenLink();
        assertTrue(manager.getWomenPage().isDisplayedWomenCard());

        manager.getWomenPage().clickCheckboxCategoriesTops();
        manager.getWomenPage().clickCheckboxCategoriesDresses();

        assertTrue(manager.getWomenPage().isEnabledCheckboxCategoryTops());
        assertTrue(manager.getWomenPage().isEnabledCheckboxCategoryDresses());

        manager.getWomenPage().clickCheckboxSizeS();
        manager.getWomenPage().clickCheckboxSizeM();
        manager.getWomenPage().clickCheckboxSizeL();

        assertTrue(manager.getWomenPage().isEneabledCheckboxSizeS());
        assertTrue(manager.getWomenPage().isEnabledCheckboxSizeM());
        assertTrue(manager.getWomenPage().isEnabledCheckboxSizeL());

        manager.getWomenPage().disableAllCheckbox();
        assertFalse(manager.getWomenPage().isDisableAllCheckbox());

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 1100)");

        WaitTools.isElementVisible(driver, manager.getWomenPage().grabPriceSlider());
        Actions bulider = new Actions(driver);
        bulider.dragAndDropBy(manager.getWomenPage().grabPriceSlider(),110,0 ).build().perform();

        assertEquals("$32.65 - $53.00", manager.getWomenPage().getTextFromAfterGrabValueOfPrice());

        driver.quit();
    }
///-----------------------------ZAD 3--------------------------------------\\\
    @Test
    public void searchMainPageTest(){
        driver.get("http://automationpractice.com");

        manager.getMainPage().searchingFor("dress");
        manager.getMainPage().tapSearchButton();

        WebElement resultWord = manager.getSearchResultPage().getResultSearchWorldPublic();
        WaitTools.isElementVisible(driver, resultWord);
        String checkResultWord = manager.getSearchResultPage().getResultSearchWorld();
        assertTrue(checkResultWord.contains("DRESS"));

        driver.quit();
    }
///-------------------------------ZAD 4-----------------------------------------\\\
    @Test
    public void womenListAmplificactionMainPageTest(){
        driver.get("http://automationpractice.com");

        WebElement waitWomanList = manager.getMainPage().aplificationWomenList();
        WaitTools.isElementVisible(driver, waitWomanList);

        Actions builder = new Actions(driver);
        builder.contextClick(manager.getMainPage().aplificationWomenList());
        builder.moveToElement(manager.getMainPage().aplificationWomenList()).build().perform();

        assertTrue(manager.getMainPage().isVisibleAplificationWomenList());
        driver.quit();
    }
///-------------------------------ZAD 5-------------------------------------------\\\
    @Test
    public void womenPageAddProductsToShopingBasketTest(){

        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 950)");

        Actions builder = new Actions(driver);
        builder.moveToElement(manager.getWomenPage().findToAddToCardButton()).build().perform();
        assertTrue(manager.getWomenPage().isVisibleAddToCardButton());

        WaitTools.isElementVisible(driver, manager.getWomenPage().clickAddToCardButton());
        builder.click(manager.getWomenPage().clickAddToCardButton()).build().perform();

        WaitTools.isElementVisible(driver, manager.getPopUpPage().procedToCheckoutButtonWebElement());
        assertTrue(manager.getPopUpPage().isVisibleProccedToCheckoutButton());

        builder.click(manager.getPopUpPage().procedToCheckoutButtonWebElement()).build().perform();
        WaitTools.isElementVisible(driver, manager.getPopUpPage().shoppingCartSummaryWebElement());
        assertTrue(manager.getPopUpPage().isVisibleShoppingCartSummary());

        ////-----ZAD 6-----\\\\

        manager.getShoppingBasketPage().clickPlusButton();
        assertTrue(manager.getShoppingBasketPage().isVisiblePlusButton());

        WebElement numberOf = manager.getShoppingBasketPage().summaryQtyNumberWebElement();
        assertTrue(WaitTools.isElementOnPage(driver,numberOf,"value", "2"));

        driver.quit();
    }
    ///----------------------------------ZAD 7-------------------------------------------------\\\
    @Test
    public void veryficationInformationLinkTest()  {

        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1400)");

        manager.getWomenPage().clickInformationLink();
        assertTrue(manager.getInformationPage().isVisibleReturnHomePageButton());

        manager.getInformationPage().clickReturnHomePageButton();
        assertTrue(manager.getMainPage().isVisibeMainPageElement());

        driver.quit();
    }

    @Test
    public void veryficationEngineAddToNewsletterTest(){
        driver.get("http://automationpractice.com");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 2500)");

        manager.getMainPage().newsletterInputAddressEmail();
        manager.getMainPage().clickSubmitNewsletter();

        WaitTools.isElementVisible(driver, manager.getMainPage().checkAlertMessageWebElement());
        String outputWord = manager.getMainPage().checkAlertMessage();
        assertTrue(outputWord.contains("Newsletter : You have successfully subscribed to this newsletter.") // Email address is not in base
                || outputWord.contains("Newsletter : This email address is already registered."));     // Or email address already is in base

    }

    @Test
    public void signUpTest() {
        driver.get("http://automationpractice.com");

        manager.getMainPage().clickSignInLink();
        manager.getAuthenticationPage().inputUserEmailAddress();
        manager.getAuthenticationPage().clickSubmitButton();

        assertTrue(WaitTools.isElementVisible(driver, manager.getCreateAnAccountPage().createAnAccountPageNameWebElement()));

        WaitTools.isElementVisible(driver, manager.getCreateAnAccountPage().genderMrRadioButtonWebElement());

        manager.getCreateAnAccountPage().clickOnMrRadioButton();
        assertTrue(WaitTools.isElementSelected(driver, manager.getCreateAnAccountPage().checkMrRadioButton()));
        assertFalse(WaitTools.isElementSelected(driver, manager.getCreateAnAccountPage().checkMrsRadioButton()));

        manager.getCreateAnAccountPage().clickOnMrsRadioButton();
        assertTrue(WaitTools.isElementSelected(driver, manager.getCreateAnAccountPage().checkMrsRadioButton()));
        assertFalse(WaitTools.isElementSelected(driver, manager.getCreateAnAccountPage().checkMrRadioButton()));

    }



}
