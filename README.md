###  Automatización Screenplay

Contains `Java`, `Gherkin`, `Cucumber`, `Screenplay`, `Serenity`

1. Feature's Statement

```Gherkin
Feature: Suite serenity demos Business Unit and Meeting schedule
  As a user of the Serenity Demos website
  I want to sing in create a Business Unit and a Meeting
  To verify that the operations are correct	
```

2. It's runs at the start of each scenario
```Gherkin
Background: Opens the browser in serenity demo page
    Given Camilo opens the browser in the home page
```

3. The user logs in with their wrong credentials
```Gherkin
  Scenario: Login with wrong credentials
    When he enters his credentials, wrong user and serenity
    Then he should see the wrong credentials text message Usuario o contraseña invalido!
    And he closes the browser
```
4. Scenario Create Business unit
```Gherkin
Scenario Outline: Create new Business unit
  Given he enters his credentials, admin and serenity
  When he creates new business unit as <businessUnits>
  Then he should see the business unit name was created
  And he should delete business unit
  And he closes the browser
  
  Examples:
    | businessUnits |
    | Business Unit |
```
5. TestRunner class executes all tests with `@Regression` tag
```Java
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"co.com.certification.serenitydemo.stepsdefinitions"},
        tags = "@Regression")
public class Runner {}
```