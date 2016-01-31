Feature: Smoketest of delivery options endpoints

  @smoke-test-rest @smoke-test
  Scenario Outline: Endpoints return healthy http status
    Given I have a base url "http://www.metapack.com"
    When I make a get request to the endpoint "<endpoint>"
    Then I get a response with a "<code>" status code
    Examples:
      | endpoint           | code |
      | /metapack-products | 200  |
      | /retailers         | 200  |
      | /bogus-url         | 404  |
