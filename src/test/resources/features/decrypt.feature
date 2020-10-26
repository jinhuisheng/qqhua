Feature: user decrypt message from encoded image

  Scenario: user decode message
    Given user opens home page
    When user uploads encoded picture "src/test/resources/encrypted_with_hello.png"
    Then user sees decoded message "hello"
