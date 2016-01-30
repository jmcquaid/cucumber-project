import groovy.json.JsonSlurper
import groovyx.net.http.RESTClient

import static cucumber.api.groovy.EN.*


When(~/^I make a "(.*?)" request to the endpoint "(.*?)"$/) { String method, String endpoint ->
    def baseUrl = System.getProperty('baseUrl')

    def response = null
    switch (method){
        case "GET":
            def urlStr = baseUrl+endpoint
            println "Making GET request to ${urlStr} ..."
            def client = new RESTClient(baseUrl)
            response = client.get(path: endpoint)
            break
        case "POST":
            throw new Exception("Step does not currently support method: ${method}!")
            break
        default:
            throw new Exception("Step does not currently support method: ${method}!")
    }
    testContext.addApiResponseToContext(response)
}

Then(~/^I get a response with a "(.*?)" status code$/) { String code ->
    assert code.toInteger() == testContext.getLastApiResponse().status
}