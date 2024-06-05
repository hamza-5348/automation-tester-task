package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModelSelectPage extends BasePage {
    public ModelSelectPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getMonthlyPaymentButton() {
        return getSingleElementByCssSelector("button[aria-label='MONTHLY PAYMENT']");
    }

    private WebElement getMinSlider() {
        return getElementById("handle_min");
    }

    private WebElement getMaxSlider() {
        return getElementById("handle_max");
    }

    private void setMonthlyPayment(String min, String max) {
        WebElement minSlider = getMinSlider();
        WebElement maxSlider = getMaxSlider();

        actions().clickAndHold(minSlider).moveByOffset(50, 0).release().perform();
        actions().clickAndHold(maxSlider).moveByOffset(-25, 0).release().perform();

    }

    private WebElement getCarModelAtPosition(int position) {
        return getMultipleElementByCssSelector(".fc-nameplate__imageOverlay").get(position);
    }

    private void setDeposit(String deposit) {
        WebElement depositInput = getElementById("deposit");
        depositInput.clear();
        depositInput.sendKeys(deposit);
    }

    private void clickAcceptValuesAndCalculate() {
        WebElement acceptValuesButton = getSingleElementByCssSelector(".fc-cta__cta.fc-cta__cta--primary");
        acceptValuesButton.click();
    }

    private String getResults() {
        WebElement resultsElement = getSingleElementByCssSelector(".fc-filter-bar-disclaimer__disclaimer__count");
        return resultsElement.getText();
    }

    private List<WebElement> getAllNameplates() {
        return getMultipleElementByCssSelector(".fc-nameplate__nameplate.fc-nameplate__nameplate--4-per-row");
    }

    public boolean isInitialized() {
        return getSingleElementByCssSelector(".fc-nameplates__nameplates").isDisplayed();
    }

    public boolean checkNoOfVehiclesDisplayed(int n) {
        List<WebElement> nameplates = getAllNameplates();
        return (nameplates.size() == n);
    }

    public boolean isMonthlyPageInitialized() {
        return getSingleElementByCssSelector(".fc-filter-bar__filter-bar").isDisplayed();
    }

    public boolean isResultsPageInitialized() {
        return getSingleElementByCssSelector(".fc-filter-bar-disclaimer__disclaimer__count").isDisplayed();
    }

    public void clickOnMonthlyTabButton() {
        WebElement monthlyPaymentBtn = getMonthlyPaymentButton();
        monthlyPaymentBtn.click();
    }

    public void setMonthlyPaymentTo(String monthlyPayment) {
        // Change the monthly payment to £750
        setMonthlyPayment(monthlyPayment, monthlyPayment);
    }

    public void setDepositTo(String deposit) {
        setDeposit(deposit);
    }

    public void clickOnAcceptValueBtn() {
        clickAcceptValuesAndCalculate();
    }

    public String getTotalResult() {
        return getResults();
    }

    public PersonalisedQuotePage selectCarModel() {
        WebElement carModelItem = getCarModelAtPosition(1);
        carModelItem.click();
        return new PersonalisedQuotePage(driver);
    }
    // TODO: Add methods in to support interacting with the model selection page.
}