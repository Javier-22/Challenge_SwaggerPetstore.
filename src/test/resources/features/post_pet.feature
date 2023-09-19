Feature: Automation of pet store

  @Test
  Scenario: Add a new pet at store

    Given I want consume the services of pet store
    When add a new pet at store
      | id         | name   | photoUrls | status    |
      | 1234569878 | Pepita | N/A       | available |
    And I consult the previously added pet by 1234569878
    And I update the data of pet
      | id         | name   | photoUrls | status     |
      | 1234569878 | canela | N/A       | falseeeee1 |
    Then I consult the pet modified by name canela