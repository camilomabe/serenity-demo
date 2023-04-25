Feature: Suite serenity demos Login

  As a user of the Serenity Demos website
  I want to see my wrong user or password
  To verify that the credential are incorrect

  Background: Opens the browser in serenity demo page
    Given Camilo opens the browser in the home page

  @WrongLogin @Regression
  Scenario: Login with wrong credentials
    When he enters his credentials, wrong user and serenity
    Then he should see the wrong credentials text message Error de validación: ¡Nombre de usuario o contraseña inválidos!
    And he closes the browser

  @Login @Regression
  Scenario: Login with ok credentials
    When he enters his credentials, admin and serenity
    Then he should see the admin in the login home page
    And he closes the browser


  @MapList @Regression
  Scenario Outline: Login with right credentials
    When he enters his credentials from a list map
      | user   | password   |
      | <user> | <password> |
    Then he should see the admin in the login home page
    And he closes the browser
    Examples:
      | user  | password |
      | admin | serenity |
