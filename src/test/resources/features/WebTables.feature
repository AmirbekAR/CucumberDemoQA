Feature: Web Tables for example

@Smoke
 Scenario: Add user Registration form
    Given user in on the Web Tables
    When fills in new users
     | First Name   | John              |
     | Last Name    | Doe               |
     | Email        | johnDoe@gmail.com |
     | Age          | 25                |
     | Salary       | 150000            |
     | Department   | IT                |
  Then get text list of user