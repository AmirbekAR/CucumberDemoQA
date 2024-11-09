Feature: Text Box

  Background:
    Given user is on Text box page

  @Regression
  Scenario: Fill up text box form with valid data
    And user enter full name
    And user enter email
    And user enter current address
    And user enter permanent address
    When user click submit button
    Then user should successfully

  @Regression
  Scenario: Data table with pojo example
    And fill up Text box form with following data
      | fullName | email             | currentAddress     | permanentAddress       |
      | Jim Kerry| kerry@gmail.com   | Hollywood         | somePermanentAddress  |


  @Regression
Scenario: Data tables User updates profile information
      When the user updates their profile with the following information:
        | Field       | Value          |
        | First Name  | John Doe          |
        | Email       | john.doe@example.com |
        | Current address       | some address 123 |
        | Permanent address       | some address 123/1 |
#      Then the user should see a confirmation message