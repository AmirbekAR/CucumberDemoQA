Feature: Text Box

@DataOne
Scenario: Print user data without opening the page
Given user is not on Text box page
And fill up the form with following with data
| Name       | Email              | Current Address           | Permanent Address         |
| Alice Doe  | alice@example.com  | 123 Maple St, Springfield | 456 Oak St, Springfield   |
| Bob Smith  | bob@example.com    | 789 Pine St, Springfield  | 101 Birch St, Springfield |
| Charlie Lee| charlie@example.com| 234 Cedar St, Springfield | 567 Willow St, Springfield |
| David Brown| david@example.com  | 345 Elm St, Springfield   | 678 Ash St, Springfield   |
| Eve White  | eve@example.com    | 456 Cherry St, Springfield | 789 Spruce St, Springfield |
