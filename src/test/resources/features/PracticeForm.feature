Feature: Practice Form

  @Smoke
  Scenario: Student Registration Form
    Given Student Registration Form
    And user enter first name
    And user enter last name
    And user enter email for Practice form
    And user choose gender "Female"
    And user enter mobile number
    And user enter date of birth
    And user choose subjects
    And user choose hobbies "Reading"
    And user download picture
    And user enter current address for Practice form
    And user select state "NCR", "Delhi"
    When user click submit button for Practice for
