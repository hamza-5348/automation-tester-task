package com.connect_group.tests.financecalculator;

import com.connect_group.pages.financecalculator.FilterByPage;
import com.connect_group.pages.financecalculator.ModelSelectPage;
import com.connect_group.pages.financecalculator.PersonalisedQuotePage;
import com.connect_group.pages.financecalculator.PopupHandler;
import com.connect_group.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FinanceCalculatorTest extends BaseTest {

    private ModelSelectPage modelSelectPage;
    private FilterByPage filterByPage;
    private PersonalisedQuotePage personalisedQuotePage;
    private PopupHandler popupHandler;

    @BeforeEach
    void setupAndNavigateToUrl() {
        modelSelectPage = new ModelSelectPage(driver);
        filterByPage = new FilterByPage(driver);
        personalisedQuotePage = new PersonalisedQuotePage(driver);
        popupHandler = new PopupHandler(driver);

        open("https://www.landrover.co.uk/offers-and-finance/finance-calculator.html");
    }

    @Test
    void ensureModelSelectPageIsPresent() {
        assertTrue(modelSelectPage.isInitialized());
    }


    // TODO: Complete the each of the tests under the "Tasks to Complete" section of the README.md
    @Test
    void ensureNumberOfVehicleDisplayed() {
        assertTrue(modelSelectPage.checkNoOfVehiclesDisplayed(7));
    }

    @Test
    void changeMonthlyPaymentAndCalculateResults() {
        assertTrue(modelSelectPage.isInitialized());
        popupHandler.acceptCookies();
        popupHandler.closePopup();
        modelSelectPage.clickOnMonthlyTabButton();
        assertTrue(modelSelectPage.isMonthlyPageInitialized());
        modelSelectPage.setMonthlyPaymentTo("750");
        modelSelectPage.setDepositTo("20000");
        modelSelectPage.clickOnAcceptValueBtn();
        assertTrue(modelSelectPage.isResultsPageInitialized());
        assertEquals("23 results", modelSelectPage.getTotalResult());
    }


    @Test
    void selectCarModelAndReRouteBackToFinanceCalculator() {
        popupHandler.acceptCookies();
        popupHandler.closePopup();
        assertTrue(modelSelectPage.isInitialized());
        popupHandler.closeBottomPopUp();
        personalisedQuotePage = modelSelectPage.selectCarModel();
        assertTrue(personalisedQuotePage.isInitialized());
        modelSelectPage = personalisedQuotePage.clickOnChangeVehicleButton();
        assertTrue(modelSelectPage.isInitialized());
    }
}