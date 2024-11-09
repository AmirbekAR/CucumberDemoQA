Feature: People tests

  @Regression
  Scenario: Speaker exist
    Given I open page "https://heisenbug.ru"
    When I click on "О нас" button
    Then I see "Леонид Руденко" speaker
