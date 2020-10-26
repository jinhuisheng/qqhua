Feature: encrypt message into picture

  Scenario: user encode image
    Given user opens home page
    When user uploads picture with message "Hello" and file "src/test/resources/banner.png"
    Then user sees encoded picture
