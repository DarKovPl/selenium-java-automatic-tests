package com.sda.pages;

import com.sun.glass.ui.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenPage {

    @FindBy (className = "sf-with-ul")
    private WebElement womenLink;
    @FindBy (xpath = "/html/body/div/div[2]/div/div[3]/div[2]/div[1]/div")
    private WebElement womenCardMainPicture;
    @FindBy (id = "layered_category_4")
    private WebElement checkboxCategoriesTops;
    @FindBy (id = "layered_category_8")
    private WebElement checkboxCategoriesDresses;
    @FindBy (id = "layered_id_attribute_group_1")
    private WebElement checkboxSizeS;
    @FindBy (id = "layered_id_attribute_group_2")
    private WebElement checkboxSizeM;
    @FindBy (id = "layered_id_attribute_group_3")
    private WebElement checkboxSizeL;
    @FindBy (css = "li.ajax_block_product:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h5:nth-child(1)")
    private WebElement findAddToCartButton1;
    @FindBy (xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    private WebElement addToCardButton;
    @FindBy (xpath = "/html/body/div/div[2]/div/div[3]/div[1]/div[2]/div[1]/form/div/div[10]/ul/div/div/a[1]")
    private WebElement priceSlider;
    @FindBy (id = "layered_price_range")
    private WebElement valueOfPrice;
    @FindBy (xpath = "/html/body/div/div[2]/div/div[3]/div[1]/section/p/a")
    private WebElement informationLink;

    ///-------Women_Page------------\\\
    public void clickWomenLink(){
        womenLink.click();
    }
    public boolean isDisplayedWomenCard(){
        return womenCardMainPicture.isDisplayed();
    }
    public void disableAllCheckbox(){
        checkboxCategoriesTops.click();
        checkboxCategoriesDresses.click();
        checkboxSizeS.click();
        checkboxSizeM.click();
        checkboxSizeL.click();
    }
    public boolean isDisableAllCheckbox(){
        return checkboxCategoriesDresses.isSelected() && checkboxCategoriesTops.isSelected()
                && checkboxSizeS.isSelected() && checkboxSizeM.isSelected() && checkboxSizeL.isSelected();
    }


    ///-------- Categories--------------\\\
    public void clickCheckboxCategoriesTops(){
        checkboxCategoriesTops.click();
    }
    public void clickCheckboxCategoriesDresses(){
        checkboxCategoriesDresses.click();
    }
    public boolean isEnabledCheckboxCategoryTops(){
       return checkboxCategoriesTops.isEnabled();
    }
    public boolean isEnabledCheckboxCategoryDresses(){
        return checkboxCategoriesDresses.isEnabled();
    }
    ///-----------Size--------------------\\\
    public void clickCheckboxSizeS(){
        checkboxSizeS.click();
    }
    public void clickCheckboxSizeM(){
        checkboxSizeM.click();
    }
    public void clickCheckboxSizeL(){
        checkboxSizeL.click();
    }
    public boolean isEneabledCheckboxSizeS(){
        return checkboxSizeS.isEnabled();
    }
    public boolean isEnabledCheckboxSizeM(){
        return checkboxSizeS.isEnabled();
    }
    public boolean isEnabledCheckboxSizeL(){
        return checkboxSizeL.isEnabled();
    }
///---------------Add_Products_To_Shopping_Basket--------\\\

    public WebElement findToAddToCardButton(){
        return findAddToCartButton1;
    }
    public WebElement clickAddToCardButton(){
        return addToCardButton;
    }
    public boolean isVisibleAddToCardButton(){
        return addToCardButton.isDisplayed();
    }
    ///----------------Slider----------\\\
    public WebElement grabPriceSlider(){
        return priceSlider;
    }
    public WebElement afterGrabValueOfPrice(){
        return valueOfPrice;
    }

    public String getTextFromAfterGrabValueOfPrice() {
        return afterGrabValueOfPrice().getText();
    }
    ////------------------Information--------------------\\\

    public void clickInformationLink(){
        informationLink.click();
    }


}
