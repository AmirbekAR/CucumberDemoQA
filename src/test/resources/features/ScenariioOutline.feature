Feature: Scenario Outline: example

  @Smoke
  Scenario Outline: Scenario Outline: examples
    Given user is on Orange HRM login page
    And user should login with following credentials "<username>" "<password>"
    Examples:
      | username | password |
      | Admin | admin123 |
      | Admin1 | admin123 |
      | Admin | admin1235 |

#    Есть функционал и надо проверить с разными наборами данных и если хотим проверить на все данные
#  то используем этот метод на проверку правильности и на ошибки. То есть это сценарий на тест кейс похож.