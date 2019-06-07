package com.sda.Tests;
import com.sda.Tools.PageObjectManager;
import com.sda.Tools.PageObjectManager1;
import com.sda.Tools.WaitTools;


import org.junit.After;
import org.junit.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import static org.junit.Assert.*;


public class MainToolTest {
    private WebDriver driver;
    private PageObjectManager manager;
    private WebDriver driver1;
    private PageObjectManager1 manager1;

    public MainToolTest(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        //driver  = new ChromeDriver();
        driver = new FirefoxDriver();
        driver1 = new FirefoxDriver();
        manager  = new PageObjectManager(driver);
        manager1 = new PageObjectManager1(driver1);
    }
    @Test
    public void mainPageLinkTest(){
        driver.get("http://automationpractice.com");
        manager.getMainPage().clickSaleLink();
        assertTrue(manager.getMainPage().isVisiblePageAfterSaleLink());
    }
    @Test
    public void mainPageLinkTest_1(){
        driver.get("http://automationpractice.com");
        manager.getMainPage().clickThreeMovePictureLink();
        assertTrue(manager.getMainPage().isVisiblePageAfterSaleLink());
    }
    @Test
    public void mainPageLinkTest_2(){
        driver.get("http://automationpractice.com");
        manager.getMainPage().clickUpSaleLink();

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
    }
    @Test
    public void veryficationEngineAddToNewsletterTest(){
        driver.get("http://automationpractice.com");
        driver1.get("http://www.yopmail.com/pl/email-generator.php");

        WaitTools.isElementVisible(driver1, manager1.getRandomEmailAddress().randomAddresEmailWebElement());
        String randomEmail = manager1.getRandomEmailAddress().getRandomAddressEmail();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 2500)");

        manager.getMainPage().addRandomEmail().sendKeys(randomEmail);
        manager.getMainPage().clickSubmitNewsletter();

        WaitTools.isElementVisible(driver, manager.getMainPage().checkAlertMessageWebElement());
        String outputWord = manager.getMainPage().checkAlertMessage();
        assertTrue(outputWord.contains("Newsletter : You have successfully subscribed to this newsletter."));


    }
    @Test
    public void signUpTest() {
        driver.get("http://automationpractice.com");
        driver1.get("http://www.yopmail.com/pl/email-generator.php");

        WaitTools.isElementVisible(driver1, manager1.getRandomEmailAddress().randomAddresEmailWebElement());
        String randomEmail = manager1.getRandomEmailAddress().getRandomAddressEmail();

        manager.getMainPage().clickSignInLink();
        manager.getAuthenticationPage().inputUserEmailAddressWebElement().sendKeys(randomEmail);

        WaitTools.isElementOnPage(driver, manager.getAuthenticationPage().inputUserEmailAddressWebElement(),
                "value", randomEmail);

        String userEmailAddress = manager.getAuthenticationPage().getUserEmailAddressText();
        manager.getAuthenticationPage().clickSubmitButton();

        assertTrue(WaitTools.isElementVisible(driver, manager.getCreateAnAccountPage().createAnAccountPageNameWebElement()));

        WaitTools.isElementVisible(driver, manager.getCreateAnAccountPage().genderMrRadioButtonWebElement());

        manager.getCreateAnAccountPage().clickOnMrRadioButton();
        assertTrue(WaitTools.isElementSelected(driver, manager.getCreateAnAccountPage().checkMrRadioButton()));
        assertFalse(WaitTools.isElementSelected(driver, manager.getCreateAnAccountPage().checkMrsRadioButton()));

        manager.getCreateAnAccountPage().clickOnMrsRadioButton();
        assertTrue(WaitTools.isElementSelected(driver, manager.getCreateAnAccountPage().checkMrsRadioButton()));
        assertFalse(WaitTools.isElementSelected(driver, manager.getCreateAnAccountPage().checkMrRadioButton()));

        manager.getCreateAnAccountPage().addCustomerFirstName();
        manager.getCreateAnAccountPage().addCustomerLastName();

        WaitTools.isElementOnPage(driver, manager.getCreateAnAccountPage().addUserDayOfBirthWebElement(),
                "value", "31");
        Select date = new Select(manager.getCreateAnAccountPage().addUserDayOfBirthWebElement());
        date.selectByValue("31");


        WaitTools.isElementOnPage(driver, manager.getCreateAnAccountPage().addUserMonthOfBirthWebElement(),
                "value", "12");
        Select month = new Select (manager.getCreateAnAccountPage().addUserMonthOfBirthWebElement());
        month.selectByValue("12");

        WaitTools.isElementOnPage(driver, manager.getCreateAnAccountPage().addUserYearOfBirthWebElement(),
                "value", "1921");
        Select year = new Select(manager.getCreateAnAccountPage().addUserYearOfBirthWebElement());
        year.selectByValue("1921");

        assertTrue(manager.getCreateAnAccountPage().getUserAddressEmail().
                contains(userEmailAddress));
        assertTrue(manager.getCreateAnAccountPage().getUserDayOfBirth());
        assertTrue(manager.getCreateAnAccountPage().getUserMonthOfBirth());
        assertTrue(manager.getCreateAnAccountPage().getUserYearOfBirth());

        manager.getCreateAnAccountPage().addUserAddress();
        manager.getCreateAnAccountPage().addUserCity();

        Select state = new Select(manager.getCreateAnAccountPage().addUserStateWebElement());
        state.selectByValue("50");

        manager.getCreateAnAccountPage().addUserPostalCode();

        Select country = new Select(manager.getCreateAnAccountPage().selectUserCountryWebElement());
        country.selectByValue("21");

        manager.getCreateAnAccountPage().addUserPhoneNumber();

        manager.getCreateAnAccountPage().clickRegisterButton();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1150)");

        assertTrue(WaitTools.isElementOnPage(driver, manager.getCreateAnAccountPage().checkUserNameInAddressPanelWebElement(),
                "value", "Władysława"));
        assertTrue(WaitTools.isElementOnPage(driver, manager.getCreateAnAccountPage().checkUserLastNameInAddressPanelWebElement(),
                "value", "Żółciak"));
        assertTrue(WaitTools.isElementOnPage(driver, manager.getCreateAnAccountPage().userAddressWebElement(),
                "value", "Wietrzychowice 19"));
        assertTrue(WaitTools.isElementOnPage(driver, manager.getCreateAnAccountPage().userCityWebElement(),
                "value", "Wietrzychowice"));
        assertTrue(WaitTools.isElementOnPage(driver, manager.getCreateAnAccountPage().addUserStateWebElement(),
                "value", "50"));
        assertTrue(WaitTools.isElementOnPage(driver, manager.getCreateAnAccountPage().userPostalCodeWebElement(),
                "value", "80000"));
        assertTrue(WaitTools.isElementOnPage(driver, manager.getCreateAnAccountPage().userPhoneNumberWebElement(),
                "value", "555-55-55"));

        manager.getCreateAnAccountPage().addUserPassword();
        manager.getCreateAnAccountPage().clickRegisterButton();
        assertTrue(WaitTools.isElementVisible(driver, manager.getMyAccountPage().isVeryficateSignUp()));
    }
    @After
    public void closeBrowsers(){
        driver.quit();
        driver1.quit();
    }


}
