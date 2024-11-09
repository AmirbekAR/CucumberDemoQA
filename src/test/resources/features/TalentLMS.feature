Feature: All test for the web talent LMS


@Regression
  Scenario Outline:
    Given user is on TalentLMS login page
    And user log in "<Username>" "<Password>"
    And user choose menu-main "Users"
    And user click add user button
    And fill up the form with add new user
    | First Name | Last Name   | Email              | Bio            | Username  |Password  |
    | Alice      |   Doe       | alice@example.com  | for IT example | Alice   | Admin12345 |


















    Examples:
      | Username | Password |
      | Amir | Tbp#tnH4ihdRkPm |

