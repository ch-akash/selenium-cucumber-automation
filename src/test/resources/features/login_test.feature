@browser
Feature: Try selenium with WebDriver manager

  Scenario: Open practice page and select product with price 20
    Given user opens practice home page
    When click "1"st radio button
    And select product from table with description "WebSecurity Testing for Beginners-QA knowledge to next level"
    Then the product price should be "20"
    And the instructor name should be "Rahul Shetty"

  Scenario: Open practice page and select product with price 20
    Given user opens practice home page
    When select product from table with description "Selenium Webdriver with Java Basics + Advanced + Interview Guide"
    Then the product price should be "30"
    And the instructor name should be "Rahul Shetty"
    When switch to iFrame
    And click join now