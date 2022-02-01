Feature: Parking Functionality

  Background: User should be on de shino homepage
    Given User is on de shino homepage

  Scenario Outline: User should be able to see the correct parking fare for 1 day parking
    When User selects a valid parking lot from the "<parking option>" parking lot dropdown
    And User enters the valid entry date "<entry date>"
    And User enters the valid entry time "<entry time>"
    And User enters the valid exit date "<exit date>"
    And User enters the valid exit time "<exit time>"
    And User clicks on the calculate button
    Then Verifies the estimated parking cost for one day parking "<parking option>" "<parking cost>"

    Examples:
      | parking option            | entry date | entry time | exit date  | exit time | parking cost |
      | Valet Parking             | 02/01/2022 | 12:00      | 02/02/2022 | 12:00     | 18.00        |
      | Short-Term Parking        | 02/01/2022 | 12:00      | 02/02/2022 | 12:00     | 24.00        |
      | Economy Parking           | 02/01/2022 | 14:00      | 02/01/2022 | 18:30     | 10.00        |
      | Long-Term Garage Parking  | 02/01/2022 | 12:00      | 02/02/2022 | 12:00     | 12.00        |
      | Long-Term Surface Parking | 02/01/2022 | 12:00      | 02/02/2022 | 12:00     | 10.00        |










