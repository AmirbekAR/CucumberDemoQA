Feature: Проверка на

  @SmokeSwiss
  Scenario Outline: Swiss Trade test for user login
    Given User is on SwissTrade login page
    And User should login with following credentials "<username>" "<password>"
    Examples:
      |   username    | password |
      | ex_amarynbaev | 330033   |
      | ex_amarynbaev | 330034   |
      | ea_amarynbaev | 330033   |
