package steps.data.api

import groovyx.net.http.RESTClient

class HttpClient {

    static def sendRequest(HttpRequestBuilder requestBuilder) {
        def client = new RESTClient(requestBuilder.url)

        client.handler.failure = client.handler.success

        println "-- Making ${requestBuilder.method} request to url: ${requestBuilder.url}"
        def response = client."$requestBuilder.method"(requestBuilder.getAttributeMap())
        response
    }
}