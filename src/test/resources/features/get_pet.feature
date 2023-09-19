
Feature:  Get pet by status
  Background:
    Given I consume the petstore API

  Scenario: Get pet by status from https://petstore.swagger.io/
    When I get pet by status "available"
    Then I validate status "available" in response