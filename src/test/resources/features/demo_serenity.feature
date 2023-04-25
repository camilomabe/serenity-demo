Feature: Suite serenity demos Business Unit and Meeting schedule

  As a user of the Serenity Demos website
  I want to sing in create a Business Unit and a Meeting
  To verify that the operations are correct

  Background: Opens the browser in serenity demo page
    Given Camilo opens the browser in the home page

  @Unit @Regression
  Scenario Outline: Create new Business unit
    Given he enters his credentials, admin and serenity
    When he creates new business unit as <businessUnits>
    Then he should see the business unit name was created
    And he should delete business unit
    And he closes the browser

    Examples:
      | businessUnits |
      | Business Unit |

  @ScheduleMap @Regression
  Scenario Outline: Schedule a meeting for a Business unit
    Given he enters his credentials, admin and serenity
    When he creates new business unit as <businessUnits>
    And he schedules a business meeting
      | businessUnits   | businessMeeting   | meetingType   | meetingNumber   | location   | organizedBy   |
      | <businessUnits> | <businessMeeting> | <meetingType> | <meetingNumber> | <location> | <organizedBy> |
    Then he should see the business meeting was created
    And he should delete meeting and unit
    And he closes the browser

    Examples:
      | businessUnits | businessMeeting  | meetingType | meetingNumber | location | organizedBy  |
      | Business Unit | Business Meeting | Customer    | 28112022      | HQ-01    | Adam Edwards |