## My first tests in Java - Selenium WebDriver
>I'm learning automation tests with  http://automationpractice.com/index.php page.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Features](#features)
* [Status](#status)
* [Contact](#contact)

## General info
Project was started creating on course Manual Tester in SDA and it is summaries my work on practice workshops. 

## Technologies
* Selenium-java 3.141.59
* Junit 4.12
* Firefox 67.0.1 optional Chrome 74.0.3729.169  (all 64 bit)

## Code Examples
Examples of code:
`@Test
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
        assertTrue(outputWord.contains("Newsletter : You have successfully subscribed to this newsletter."));`

## Features
List of features ready and TODOs for future development
* Two of tests use another website to generate address email and using it for do tests.
* I've use differents locators.
* After change a few parameters and also uncomment driver for Chrome it is possible to do tests in Chrome browser

To-do list:
* I have to do for driver and driver1 in constructor to conditional statement because when all tests is started Browser is opening two times. Only two tests demand browser open two times.
* I have to build conditional statement for Chrome and parameters when i want testing on Chrome browser.

## Status
In PROGRESS....

## Contact
Created by Dariusz Kowalczyk (dariusz_kowalczykk@wp.pl) - feel free to contact me!
