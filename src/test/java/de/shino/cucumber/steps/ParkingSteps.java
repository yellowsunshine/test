package de.shino.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.shino.pages.ParkingCostPage;

public class ParkingSteps {
    @Given("^User is on de shino homepage$")
    public void userIsOnDeShinoHomepage() {
    }

    @When("^User selects a valid parking lot from the \"([^\"]*)\" parking lot dropdown$")
    public void userSelectsAValidParkingLotFromTheParkingLotDropdown(String parkingLot) {
        new ParkingCostPage().selectParkingLotTypeFromTheDropdown(parkingLot);
    }

    @And("^User enters the valid entry date \"([^\"]*)\"$")
    public void userEntersTheValidEntryDate(String entryDate) {
        new ParkingCostPage().selectEntryDate(entryDate);
    }

    @And("^User enters the valid entry time \"([^\"]*)\"$")
    public void userEntersTheValidEntryTime(String entryTime) {
        new ParkingCostPage().enterEntryTime(entryTime);
    }

    @And("^User enters the valid exit date \"([^\"]*)\"$")
    public void userEntersTheValidExitDate(String exitDate) {
        new ParkingCostPage().selectExitDate(exitDate);
    }

    @And("^User enters the valid exit time \"([^\"]*)\"$")
    public void userEntersTheValidExitTime(String exitTime) {
        new ParkingCostPage().enterExitTime(exitTime);
    }

    @And("^User clicks on the calculate button$")
    public void userClicksOnTheCalculateButton() {
        new ParkingCostPage().doClickOnCalculateButton();
    }

    @Then("^Verifies the estimated parking cost for one day parking \"([^\"]*)\" \"([^\"]*)\"$")
    public void verifiesTheEstimatedParkingCostForOneDayParking(String parkingType, String parkingCost)  {
        new ParkingCostPage().verifyParkingCharges(parkingType, parkingCost);
    }



}
