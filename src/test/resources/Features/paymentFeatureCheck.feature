Feature: Test the  payment journey

  Scenario: To check the payment methods
    Given user open the flipcarkt
    When User selected some product and adds to cart
    And user clicks on payments options
    Then user navigates to OTP screen.
