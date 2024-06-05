package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalisedQuotePage extends BasePage {

    public boolean isInitialized() {
        return getSingleElementByCssSelector(".fc-headers__text").isDisplayed();
    }

    public ModelSelectPage clickOnChangeVehicleButton() {
        WebElement changeVehicleButton = getSingleElementByCssSelector(".fc-cta__cta.fc-cta__cta--default-light");
        changeVehicleButton.click();
        return new ModelSelectPage(driver);
    }

    public PersonalisedQuotePage(WebDriver driver) {
        super(driver);
    }
}