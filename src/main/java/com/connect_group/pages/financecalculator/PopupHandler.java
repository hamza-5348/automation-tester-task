package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupHandler extends BasePage {


    public PopupHandler(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {

        try {
            WebElement acceptCookiesBtn = driver.findElement(By.id("truste-consent-button"));
            acceptCookiesBtn.click();
        } catch (Exception ignore) {
        }
    }

    public void closePopup() {
        try {
            WebElement closePopupBtn = driver.findElement(By.id("psyma_close_button_link"));
            closePopupBtn.click();
        } catch (Exception ignore) {
        }
    }
    public void closeBottomPopUp(){
        try{
            WebElement closePopupBtn = getSingleElementByCssSelector(".icon-close.icon-close-message");
            closePopupBtn.click();
        }
        catch (Exception ignore){
        }
    }
}
