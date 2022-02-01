package de.shino.pages;

import de.shino.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParkingCostPage extends Utility {

    private static final Logger log = LogManager.getLogger(ParkingCostPage.class.getName());

    public ParkingCostPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='ParkingLot']")
    WebElement parkingLotDropdown;

    @CacheLookup
    @FindBy(xpath = "//input[@id='StartingDate']")
    WebElement entryDate;

    @CacheLookup
    @FindBy(xpath = "//input[@id='LeavingDate']")
    WebElement exitDate;

    @CacheLookup
    @FindBy(xpath = "//input[@id='StartingTime']")
    WebElement entryTime;

    @CacheLookup
    @FindBy(xpath = "//input[@id='LeavingTime']")
    WebElement exitTime;

    @CacheLookup
    @FindBy(xpath = "//body/form[1]/input[2]")
    WebElement calculateButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='LeavingTime']//following::span[1]//b")
    WebElement estimatedParkingCost;

    public void selectParkingLotTypeFromTheDropdown(String parkingLot) {
        doSelectByVisibleTextFromDropDown(parkingLotDropdown, parkingLot);
    }

    public void selectEntryDate(String inDate) {
        doFindElementAndClearText(entryDate);
        doSendTextToElement(entryDate, inDate);
    }

    public void enterEntryTime(String inTime) {
        doFindElementAndClearText(entryTime);
        doSendTextToElement(entryTime, inTime);
    }

    public void selectExitDate(String outDate) {
        doFindElementAndClearText(exitDate);
        doSendTextToElement(exitDate, outDate);
    }

    public void enterExitTime(String outTime) {
        doFindElementAndClearText(exitTime);
        doSendTextToElement(exitTime, outTime);
    }

    public void doClickOnCalculateButton() {
        doClickOnElement(calculateButton);
    }

    public void verifyParkingCharges(String parkingLot, String parkingCharges) {
        if (parkingLot.equalsIgnoreCase("Valet Parking")) {
            Assert.assertTrue(estimatedParkingCost.getText().contains(parkingCharges));
        } else if (parkingLot.equalsIgnoreCase("Short-Term Parking")) {
            Assert.assertTrue(estimatedParkingCost.getText().contains(parkingCharges));
        } else if (parkingLot.equalsIgnoreCase("Economy Parking")) {
            Assert.assertTrue(estimatedParkingCost.getText().contains(parkingCharges));
        }else if (parkingLot.equalsIgnoreCase("Long-Term Garage Parking")) {
            Assert.assertTrue(estimatedParkingCost.getText().contains(parkingCharges));
        }else if (parkingLot.equalsIgnoreCase("Long-Term Surface Parking")) {
            Assert.assertTrue(estimatedParkingCost.getText().contains(parkingCharges));
        }else {
            System.out.println("Invalid Parking Selection");
        }

    }


}
