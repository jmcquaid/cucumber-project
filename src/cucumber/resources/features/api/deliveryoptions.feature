Feature: Smoketest of delivery options endpoints

  @smoke-test-rest @smoke-test
  Scenario Outline: Endpoints return healthy http status
    When I make a "<method>" request to the endpoint "<endpoint>"
    Then I get a response with a "<code>" status code
  Examples:
    | method | endpoint | code |
    | GET    | /mail      | 200  |
