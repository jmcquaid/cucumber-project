import static cucumber.api.groovy.EN.*
import steps.data.api.HttpRequestBuilder
import steps.data.api.HttpClient

When(~/^I make a get request to the endpoint "(.*?)"$/) { String endpoint ->
    def baseUrl = testContext.baseUrl

    def url = baseUrl + endpoint
    def headers = null
    def urlQuery = null
    def body = null

    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder(url, "get", headers, body, urlQuery)

    def response = HttpClient.sendRequest(httpRequestBuilder)
    testContext.addApiResponseToContext(response)
}

Then(~/^I get a response with a "(.*?)" status code$/) { String code ->
    assert code.toInteger() == testContext.getLastApiResponse().status
}

Then(~/^I have a base url "(.*?)"$/) { String baseUrl ->
    testContext.baseUrl = baseUrl
}